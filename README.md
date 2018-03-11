# FXML-todoApp

Esimerkki FXML:llä tehdystä sovelluksesta joka koostuu useasta näkymästä eli Scenestä.

Jokaisella näkymällä on oma kontrolleri. Sovelluksen alustusvaiheessa kontrollereille _injektoidaan_ setterimetodien avulla sovelluslogiikkaolio _TodoService_ sekä sovellusta vastaava olio.

## Sovelluksen alustus

Alustusmetodi _init_ luo näkmät eli _Scenet_ ja tallettaa ne muuttujiin _loginScene_ ja _newUserScene_. Sovellus tarjoaa apumetodit _setloginScene_ ja _setNewUserScene_ joiden avulla näkymää voi vaihtaa:

```java
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
```

## Riippuvuuksien injektointi kontrollereille

Tärkeä yksityiskohta sovelluksen alustusmetodissa on riippuvuuksien injektoiminen näkymien kontorllereille. Kirjautumisnäkymän luova koodi:

```java
FXMLLoader loginSceneLoader = new FXMLLoader(getClass().getResource("/fxml/LoginScene.fxml"));       
Parent loginPane = loginSceneLoader.load();
LoginSceneController loginSceneController = loginSceneLoader.getController();
loginSceneController.setTodoService(todoService); 
loginSceneController.setApplication(this);
loginScene = new Scene(loginPane);
```

Eli _loginSceneLoader_ oliolta saadaan Sceneä vastaava kontrolleri ja tälle injektoidaan _todoService_ ja sovellusolio _this_ settereillä.

## Näkymän vaihtaminen

Kontrollereista on nyt helppo käyttää sovelluslogiikka sekä vaihtaa näkymää. Näkymän vaihtaminen tapahtuu kutsumalla sovelluksen pääluokan _application_ metodeja, esim. _setNewUserScene_:

```java
public class LoginSceneController implements Initializable {
    private TodoService todoService;
    private TodoAppMain application;

    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    public void setApplication(Main application) {
        this.application = application;
    }
    
    // ...
   
    @FXML
    private void handleNewUser(ActionEvent event) {
        application.setNewUserScene();
    }    
    
}
```