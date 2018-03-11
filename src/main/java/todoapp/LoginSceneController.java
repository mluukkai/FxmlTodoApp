package todoapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import todoapp.domain.TodoService;

public class LoginSceneController implements Initializable {
    private TodoService todoService;
    private TodoAppMain application;

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    public void setApplication(TodoAppMain application) {
        this.application = application;
    }
    
    @FXML
    private TextField username;
    
    @FXML
    private void handleLogin(ActionEvent event) {
        System.out.println("You clicked me!");
    }
   
    @FXML
    private void handleNewUser(ActionEvent event) {
        application.setNewUserScene();
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
