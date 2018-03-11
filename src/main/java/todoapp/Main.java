package todoapp;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import todoapp.domain.TodoService;


public class Main extends Application {
    private Stage stage;
    private TodoService todoService;
    private Scene loginScene;
    
    @Override
    public void init() throws Exception {
        todoService = new TodoService(new FakeTodoDao(), new FakeUserDao());
        
        FXMLLoader loginSceneLoader = new FXMLLoader(getClass().getResource("/fxml/LoginScene.fxml"));       
        Parent loginPane = loginSceneLoader.load();
        LoginSceneController controller = loginSceneLoader.getController();
        controller.setTodoService(todoService); 
        loginScene = new Scene(loginPane);

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
              
        stage.setTitle("TodoApp");
        setloginScene();
        stage.show();
    }

    private void setloginScene() {
        stage.setScene(loginScene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
