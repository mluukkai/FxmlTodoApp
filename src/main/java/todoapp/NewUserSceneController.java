package todoapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import todoapp.domain.TodoService;

public class NewUserSceneController implements Initializable {
    private TodoService todoService;
    private TodoAppMain application;

    
    @FXML
    private TextField username;

    @FXML
    private TextField name;
    
    @FXML
    private Label errorMessage;
    
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    public void setApplication(TodoAppMain application) {
        this.application = application;
    }

    @FXML
    private void handleBack(ActionEvent event) {
        application.setloginScene();
    }   
    
    @FXML
    private void handleCreate(ActionEvent event) {
        boolean creationOk = todoService.createUser(username.getText(), name.getText());
        
        if ( creationOk  ){
            username.setText("");
            name.setText("");
            application.setloginScene(); 
        } else {
            errorMessage.setText("user creation failed");
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
