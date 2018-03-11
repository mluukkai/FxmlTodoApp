package todoapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import todoapp.domain.TodoService;

public class NewUserSceneController implements Initializable {
    private TodoService todoService;
    private TodoAppMain application;

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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
