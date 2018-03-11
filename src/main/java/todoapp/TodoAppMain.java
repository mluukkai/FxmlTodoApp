package todoapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import todoapp.domain.TodoService;


public class TodoAppMain extends Application {
    private Stage stage;
    private TodoService todoService;
    private Scene loginScene;
    private Scene newUserScene;
    
    @Override
    public void init() throws Exception {
        todoService = new TodoService(new FakeTodoDao(), new FakeUserDao());
        
        FXMLLoader loginSceneLoader = new FXMLLoader(getClass().getResource("/fxml/LoginScene.fxml"));       
        Parent loginPane = loginSceneLoader.load();
        LoginSceneController loginSceneController = loginSceneLoader.getController();
        loginSceneController.setTodoService(todoService); 
        loginSceneController.setApplication(this);
        loginScene = new Scene(loginPane);

        FXMLLoader newUserSceneLoader = new FXMLLoader(getClass().getResource("/fxml/NewUserScene.fxml"));       
        Parent newUserPane = newUserSceneLoader.load();
        NewUserSceneController newUserSceneController = newUserSceneLoader.getController();
        newUserSceneController.setTodoService(todoService); 
        newUserSceneController.setApplication(this);
        newUserScene = new Scene(newUserPane);    
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
              
        stage.setTitle("TodoApp");
        setloginScene();
        stage.show();
    }

    public void setloginScene() {
        stage.setScene(loginScene);
    }

    public void setNewUserScene() {
        stage.setScene(newUserScene);
    }    
    
    public static void main(String[] args) {
        launch(args);
    }

}
