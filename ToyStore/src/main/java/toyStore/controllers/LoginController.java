package toyStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import toyStore.entities.User;
import toyStore.entities.UserDAO;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value="/login/")
public class LoginController {

    private final UserDAO userDAO;

    @Autowired
    public LoginController(UserDAO userDAO) {

        Assert.notNull(userDAO, "User must not be null!");
        this.userDAO = userDAO;
    }




    @RequestMapping(value = "/")
    public View dashboard(String employeeEmail, String employeePassword, HttpServletRequest request) {


        //Find user in database, put into user object
        Iterable<User> users = null;
        users = userDAO.findByEmployeeEmail(employeeEmail);

        int i = 0;
        HashMap<Integer,User> usersHashMap = new HashMap<>();
        for(User user:users) {
            usersHashMap.put(i,user);
            i++;
        }

        //Check password
        User loggedUser = usersHashMap.get(0);
        if(loggedUser.getEmpoyeePassword().equals(employeePassword)){
            request.getSession().setAttribute("username",loggedUser.getEmployeeName());
            request.getSession().setAttribute("userId",loggedUser.getEmployeeId());

            //Password is correct, check position and direct to corresponding controller
            if(loggedUser.getEmployeePosition() == User.EmployeePosition.EMPLOYEE) {
                return new RedirectView("/employee/");
            } else if (loggedUser.getEmployeePosition() == User.EmployeePosition.MANAGER) {
                return new RedirectView("/manager/");
            } else if (loggedUser.getEmployeePosition() == User.EmployeePosition.OWNER) {
                return new RedirectView("/owner/");
            }

        //Password is incorrect
        } else {
            return new RedirectView("/login/");
        }
        return new RedirectView("/login/");
    }
}