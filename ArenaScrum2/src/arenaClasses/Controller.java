package arenaClasses;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import arenaClasses.DBHandler;
import arenaModels.UserModels;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class Controller extends Main  implements Initializable{

@FXML
private Label closeIcon;
@FXML
private Label errorLabel;
@FXML
private Label errorSame;
@FXML
private Label errorCommon;
@FXML
private JFXButton loginPageSignUpButton;
@FXML
private JFXButton loginPageSignInButton;
@FXML
private JFXButton GuestButton;
@FXML
private ImageView loadingGif;
@FXML
private JFXTextField loginPageUserNameTextField;
@FXML
private JFXPasswordField loginPagePasswordField;
@FXML
private JFXTextField signUpPageUserNameTextField;
@FXML
private JFXPasswordField signUpPagePasswordField;
@FXML
private JFXButton signUpPageSignUpButton;
@FXML
private JFXButton signUpPageGoBackButton;
@FXML
private Label errorLabelRegForm;
@FXML
private Label ErrorCap;
@FXML
private Label Errorshort;
@FXML
private Label ErrorNum;
@FXML
private Label attemptsLabel;
@FXML
private Label PassReq1;
@FXML
private Label PassReq2;
@FXML
private Label PassReq3;
@FXML
private Label PassReq4;
@FXML
private Label PassReq5;
@FXML
private Label PassReq6;
@FXML
private Label Errorattempts;
@FXML
private Label quoteDetected;
@FXML
private Label successLabelRegForm;
@FXML
private JFXButton spectApply;
@FXML
private JFXButton appOperatorButton;
@FXML
private JFXButton appLeagueOwnerButton;
@FXML
private JFXButton appPlayerButton;
@FXML
private JFXButton appAdvertiserButton;
@FXML
private Label appOperatorDetails;
@FXML
private Label appLeagueOwnerDetails;
@FXML
private Label appLeagueOwnerDetails1;
@FXML
private Label noRoleSelectedLabel;
@FXML
private JFXButton spectGoBackButton;
@FXML
private Label appPlayerDetails;
@FXML
private Label appPlayerDetails1;
@FXML
private Label appAdvertDetails;
@FXML
private JFXButton confGoBackButton;
@FXML
private JFXButton confYesButton;
@FXML
private JFXButton confNoButton;
@FXML
private JFXButton opSeePendingButton;
@FXML
private JFXButton opManageUsersButton;
@FXML
private JFXButton pendingGoBack;
@FXML
private TableView<TableViewController> userPendingTable;
@FXML
private TableColumn<TableViewController, Integer> pendingColumnUserID;
@FXML
private TableColumn<TableViewController, String> pendingColumnUserName;
@FXML
private TableColumn<TableViewController, Integer> pendingColumnCurrentRole;
@FXML
private TableColumn<TableViewController, Integer> pendingColumnDesiredRole;
@FXML
private JFXButton pendingApproveButton;
@FXML
private JFXButton pendingRemoveButton;
@FXML
private JFXButton pendingRefreshButton;
@FXML
private JFXButton manageUsersGoBack;
@FXML
private JFXButton manageUsersRemoveButton;
@FXML
private JFXButton manageUsersRefreshButton;
@FXML
private TableView<ManageUsersController> manageUsersTable;
@FXML
private TableColumn<ManageUsersController, Integer> manageUsersColumnUserID;
@FXML
private TableColumn<ManageUsersController, String> manageUsersColumnUserName;
@FXML
private TableColumn<ManageUsersController, Integer> manageUsersColumnCurrentRole;
@FXML
private JFXButton leagueOwnerGoToTeamsButton;
@FXML
private JFXButton playerTeamAppButton;
@FXML
private JFXButton leagueOwnerPendingButton;
@FXML
private JFXButton leagueOwnerGoToTournsButton;
@FXML
private JFXButton leagueOwnerGoToMangLeagues;
@FXML
private JFXButton leagueOwnerGoToCreateLeagues;
@FXML
private JFXButton playerTeamJoinLeague;
@FXML
private JFXButton playerTeamMangLeague;
@FXML
private JFXButton opCreateArenaButton;
@FXML 
private JFXButton opMangArenaButton;
@FXML 
private JFXButton leagueOwnerGoToCreateTournsButton;
@FXML 
private JFXButton leagueOwnerGoToManageTournsButton;
@FXML 
private JFXButton opCreateArenasButton;
@FXML 
private JFXButton opManageArenaButton;
@FXML
private JFXButton leagueOwnerGoToManagePlayers;
@FXML
private JFXButton LoCreateGame;
@FXML
private JFXButton LoCreateMatch;
@FXML
private AnchorPane loginBGPane;
@FXML
private HBox dragBar;
@FXML
private JFXButton opSetAdButton;

ResultSet rs;
ResultSetMetaData rsmd;
String currentName, currentPass,columnValue ;
int columnsNumber;
Scene scene;
Stage stage = new Stage();
private ObservableList<TableViewController>data;
private ObservableList<ManageUsersController>data2;
private PreparedStatement pst,pstTwo;
static String currName,currPass;
public static int currUserID,currRoleID,appRoleChoice;
int attempts = 0;


@Override
public void initialize(URL location, ResourceBundle resources)
{
	try{
		}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Error@ AdvertController.initialize");
	}
}
@FXML
void goToCreateMatch(ActionEvent event) throws IOException {
	 LoCreateMatch.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/MatchMaker.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
}
@FXML
void goToSetAdOp(ActionEvent event) throws IOException {
	opSetAdButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/SetAdPrices.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
}
@FXML
private void goToCreateGame(ActionEvent event) throws IOException {
	 LoCreateGame.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/GetGames.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
}
@FXML
private void goToSignUp(ActionEvent event) throws Exception {
    	loginPageSignUpButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/signUpPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        loadingGif.setVisible(true);
        }
@FXML
private void goToLoPlayersApp(ActionEvent event) throws Exception {
	    leagueOwnerPendingButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/loPlayerApp.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToMangLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToMangLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerLeagueManagementPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToCreateLeag(ActionEvent event) throws Exception {
    	leagueOwnerGoToCreateLeagues.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerNewLeague.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToJoinLeag(ActionEvent event) throws Exception {
    	playerTeamJoinLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerJoinLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToPlayerMangLeag(ActionEvent event) throws Exception {
    	playerTeamMangLeague.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/PlayerCurrentLeaguePage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
@FXML
private void goToTeamsApp(ActionEvent event) throws Exception {
    	playerTeamAppButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/teamApp.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
        }
// Log In Page Sign In Button Functionality. Checks loginPageUserNameTextField & associated Password Field against users table to see if both exist
// If both UserName & Password exist in database. Uses their Role Type to determine which View they will land on.
// Checks if the User Name & Password entered by user Exist in users Table(loginPageSignInButton Functionality)
// Determines Landing Page by Associated Role ID # if one exist.
// Role IDs: #  ROLE
    //       1  Spectator
    //       2  Operator
    //       3  League Owner
    //       4  Player
    //       5  Advertiser
@FXML
private void signIn(ActionEvent event) throws SQLException, IOException
    {
    	int roleIDCheck = 0;
    	int remain;
    	Connection myConnection = DBHandler.getConnection();
    	currentName = "\""+loginPageUserNameTextField.getText()+"\"";
    	currName = loginPageUserNameTextField.getText();
    	currPass = loginPagePasswordField.getText();
    	String SaltPass = "";
    	loadingGif.setVisible(true);
    	Boolean quote1 = Passwordchecker.quoteChecker(currName);
    	Boolean quote2 = Passwordchecker.quoteChecker(currPass);
    	Errorattempts.setVisible(false);
    	attemptsLabel.setVisible(false);
    	errorLabel.setVisible(false);
    	
    	if (quote1 ==true && quote2 == true){
    		try
    		{
    			String query = "SELECT * FROM users WHERE userName ="+ currentName;
    			PreparedStatement preparedStatement = myConnection.prepareStatement(query);
    			preparedStatement.executeQuery(query);
    			rs = preparedStatement.executeQuery(query);
    			if (attempts<4){
    				if (rs.first()){
    					String salt = rs.getString("Salt");
    					SaltPass = currPass+salt;
    					currentPass = "\""+DigestUtils.sha256Hex(SaltPass)+"\"";
    				}
    				if(!rs.isBeforeFirst())
    				{
    					errorLabel.setVisible(true);
    					loadingGif.setVisible(true);
    				}
    				String queryOne = "SELECT * FROM users WHERE userName ="+ currentName + " AND userPassword =" + currentPass;
    				PreparedStatement preparedStatement2 = myConnection.prepareStatement(queryOne);
    				preparedStatement2.executeQuery(queryOne);
    				rs = preparedStatement2.executeQuery(queryOne);
    				rsmd = rs.getMetaData();
    				columnsNumber = rsmd.getColumnCount();
    				if (rs.first())
    				{
    					roleIDCheck = rs.getInt(4);
    					currUserID = rs.getInt("userID");
    					currRoleID = rs.getInt("userRoleID");
    				}
    				if(!rs.isBeforeFirst())
    				{
    					errorLabel.setVisible(true);
    					loadingGif.setVisible(true);
    					attempts++;
    					remain = 5- attempts;
    					attemptsLabel.setText(""+remain+" attempts remain");
    					attemptsLabel.setVisible(true);
    				}
    				if((rs.first()) && roleIDCheck == 0)
    				{
    					loginPageSignInButton.getScene().getWindow().hide();
    					loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
    					scene = new Scene(loader.load());
    					stage.setScene(scene);
    					stage.setResizable(false);
    					stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    					stage.setTitle("Arena");
    					stage.show();
    				}
    				if((rs.first()) && roleIDCheck == 1)
    				{
    					loginPageSignInButton.getScene().getWindow().hide();
    					loader.setLocation(getClass().getResource("/arenaViews/leagueOwnerLanding.fxml"));
    					scene = new Scene(loader.load());
    					stage.setScene(scene);
    					stage.setResizable(false);
    					stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    					stage.setTitle("Arena");
    					stage.show();
    					UserModels UserID = new UserModels(currUserID);
    					UserID.setUserID(currUserID);
    				}
    				if((rs.first()) && roleIDCheck == 2)
    				{
    					loginPageSignInButton.getScene().getWindow().hide();
    					loader.setLocation(getClass().getResource("/arenaViews/advertisorLanding.fxml"));
    					scene = new Scene(loader.load());
    					stage.setScene(scene);
    					stage.setResizable(false);
    					stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    					stage.setTitle("Arena");
    					stage.show();
    					UserModels UserID = new UserModels(currUserID);
    					UserID.setUserID(currUserID);
    				}
    				if((rs.first()) && roleIDCheck == 3)
    				{
    					loginPageSignInButton.getScene().getWindow().hide();
    					loader.setLocation(getClass().getResource("/arenaViews/playerLanding.fxml"));
    					scene = new Scene(loader.load());
    					stage.setScene(scene);
    					stage.setResizable(false);
    					stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    					stage.setTitle("Arena");
    					stage.show();
    					UserModels UserID = new UserModels(currUserID);
    					UserID.setUserID(currUserID);
    				}
    				if((rs.first()) && roleIDCheck == 4)
    				{
    					loginPageSignInButton.getScene().getWindow().hide();
    					loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
    					scene = new Scene(loader.load());
    					stage.setScene(scene);
    					stage.setResizable(false);
    					stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    					stage.setTitle("Arena");
    					stage.show();
    				}
    			}
    			else{
    				remain = 5- attempts-1;
    				attemptsLabel.setText(""+remain+" attempts remain");
    				loginPageSignInButton.setVisible(false);
    				Errorattempts.setVisible(true);
    			}	
    		}
    		catch(SQLException e)
    		{
    			System.out.println("ERROR: Issue Checking User Name & Password.");
    			e.printStackTrace();
    		}
    		finally
    		{
    			myConnection.close();
    		}
    	}
    	else{
    		loginPageSignInButton.setVisible(false);
    		loginPageUserNameTextField.setVisible(false);
    		loginPagePasswordField.setVisible(false);
    		loginPageSignUpButton.setVisible(false);
    		GuestButton.setVisible(false);
    		quoteDetected.setVisible(true);
    	}
    }
@FXML
private void closeApplication(MouseEvent event)
    {
	    System.gc();
        System.exit(0);
    }
@FXML
private void goBackToSignIn(ActionEvent event) throws Exception
    {
    	signUpPageGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
    	System.gc();
     }
@FXML
private void firstSignUp (ActionEvent event) throws SQLException, IOException
    {
    	Connection myConnection = DBHandler.getConnection();
        String signUpName ="\""+ signUpPageUserNameTextField.getText()+ "\"";
        String signUpPassword = signUpPagePasswordField.getText();
    	String queryFour = "SELECT * FROM arenadatabase.users WHERE users.userName ="+signUpName+"";
    	Boolean LengthT = Passwordchecker.lengthchecker(signUpPassword);
    	Boolean CapT = Passwordchecker.CapitalChecker(signUpPassword);
    	Boolean numT = Passwordchecker.NumberChecker(signUpPassword);
    	Boolean sameUP = Passwordchecker.userPass(signUpPageUserNameTextField.getText(), signUpPagePasswordField.getText());
    	Boolean commonPass = Passwordchecker.dictionary(signUpPassword);
    	Boolean quote1 = Passwordchecker.quoteChecker(signUpPassword);
    	Boolean quote2 = Passwordchecker.quoteChecker(signUpPageUserNameTextField.getText());
    	ErrorCap.setVisible(false);
		ErrorNum.setVisible(false);
		Errorshort.setVisible(false);
		errorCommon.setVisible(false);
		errorSame.setVisible(false);
    	
    	if (quote1 ==true && quote2 == true){
    		try
    		{
    			PreparedStatement preparedStatementOne = myConnection.prepareStatement(queryFour);
    			preparedStatementOne.executeQuery(queryFour);
    			rs = preparedStatementOne.executeQuery(queryFour);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    			System.out.println("ERROR @ Conrol.firstSignUp. First Try/Catch.");
    		}
    		if(rs.first())
    		{
    			PassReq1.setVisible(false);
    			PassReq2.setVisible(false);
    			PassReq3.setVisible(false);
    			PassReq4.setVisible(false);
    			PassReq5.setVisible(false);
    			PassReq6.setVisible(false);
    			successLabelRegForm.setVisible(false);
    			errorLabelRegForm.setVisible(true);
    			myConnection.close();
    		}
    		
    		else if(!rs.isBeforeFirst()&&LengthT==true&&CapT==true&&numT==true&&sameUP==true&&commonPass==true)
    		{
    			String Salty = RandomStringUtils.randomAlphanumeric(5);
    			String SaltPass = signUpPassword+Salty;
    			String sha256hex = DigestUtils.sha256Hex(SaltPass);
    			String insert = "INSERT INTO users(userName,userPassword,Salt)"
    					+ "VALUES (?,?,?)";
    			try
    			{
    				PreparedStatement preparedStatement = myConnection.prepareStatement(insert);
    				preparedStatement.setString (1, signUpPageUserNameTextField.getText());
    				preparedStatement.setString (2, sha256hex);
    				preparedStatement.setString (3,Salty);
    				preparedStatement.execute();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    				System.out.println("ERROR: Prepared Statement Failure @ Sign Up Button. Control.firstSignUp. 2nd Try/Catch.");
    			}
    			finally
    			{
    				myConnection.close();
    			}
    			PassReq1.setVisible(false);
    			PassReq2.setVisible(false);
    			PassReq3.setVisible(false);
    			PassReq4.setVisible(false);
    			errorLabelRegForm.setVisible(false);
    			successLabelRegForm.setVisible(true);
    			}
    		else if (sameUP==false){
    			PassReq1.setVisible(false);
    			PassReq2.setVisible(false);
    			PassReq3.setVisible(false);
    			PassReq4.setVisible(false);
    			PassReq5.setVisible(false);
    			PassReq6.setVisible(false);
    			errorSame.setVisible(true);
    		}
    		else if (commonPass==false){
    			PassReq1.setVisible(false);
    			PassReq2.setVisible(false);
    			PassReq3.setVisible(false);
    			PassReq4.setVisible(false);
    			PassReq5.setVisible(false);
    			PassReq6.setVisible(false);
    			errorCommon.setVisible(true);
    		}
    		else
    		{
    			PassReq1.setVisible(false);
    			PassReq2.setVisible(false);
    			PassReq3.setVisible(false);
    			PassReq4.setVisible(false);
    			PassReq5.setVisible(false);
    			PassReq6.setVisible(false);
    			
    			if(LengthT==false)
    				Errorshort.setVisible(true);
    			if(CapT==false)
    				ErrorCap.setVisible(true);
    			if(numT==false)
    				ErrorNum.setVisible(true);
    			myConnection.close();
    		}
    	}
    	else {
    		signUpPageSignUpButton.setVisible(false);
    		signUpPageUserNameTextField.setVisible(false);
    		signUpPagePasswordField.setVisible(false);
    		signUpPageGoBackButton.setVisible(false);
    		PassReq1.setVisible(false);
			PassReq2.setVisible(false);
			PassReq3.setVisible(false);
			PassReq4.setVisible(false);
			PassReq5.setVisible(false);
			PassReq6.setVisible(false);
    		quoteDetected.setVisible(true);
    	}
    	}
@FXML
private void goToApplicationPage(ActionEvent event) throws Exception
    {
        spectApply.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
    }
@FXML
private void goToLOTeamsPage(ActionEvent event) throws Exception
    {
    	leagueOwnerGoToTeamsButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/makeTeam.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
@FXML
private void opGoToPending(ActionEvent event) throws Exception
    {
    	opSeePendingButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorPendingPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
    }
@FXML
private void goBackToOpLanding(ActionEvent event) throws Exception
    {
    	pendingGoBack.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
    }
@FXML
private void goBackToOpLandingForMangUsers(ActionEvent event) throws Exception
    {
    	manageUsersGoBack.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/operatorLanding.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
        System.gc();
    }
@FXML
private void pendingUsersToTableView(ActionEvent event) throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	try
    	{
    		String getAllPendingApplicationQuery = ""
    				+ "SELECT  pendingTable.appUserID, userTable.userName, pendingTable.appCurrentRole, pendingTable.desired_RoleID "
    				+ "FROM pending pendingTable, users userTable "
    				+ "WHERE userTable.userID = pendingTable.appUserID";
    		ResultSet rs2 = myConnection.createStatement().executeQuery(getAllPendingApplicationQuery);
    		while(rs2.next())
    		{
    			int appUserID = rs2.getInt("pendingTable.appUserID");
				String appUserName = rs2.getString("userTable.userName");
				int appCurrentRole = rs2.getInt("pendingTable.appCurrentRole");
				int desired_RoleIDNew = rs2.getInt("pendingTable.desired_RoleID");
    			data.add(new TableViewController(appUserID, appUserName, appCurrentRole, desired_RoleIDNew));
    		}
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.pendingUsersToTableView");
    	}
    	pendingUsersToTableLoad();
    	pendingColumnUserID.setCellValueFactory(new PropertyValueFactory<>("appUserID"));
    	pendingColumnUserName.setCellValueFactory(new PropertyValueFactory<>("appUserName"));
    	pendingColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("appCurrentRole"));
    	pendingColumnDesiredRole.setCellValueFactory(new PropertyValueFactory<>("desired_RoleIDNew"));
    	userPendingTable.setItems(data);
    }
private void pendingUsersToTableLoad() throws SQLException
    {
    	Connection myConnection = DBHandler.getConnection();
    	data = FXCollections.observableArrayList();
    	try
    	{
    		String getAllPendingUsertoTableLoadQuery = ""
    				+ "SELECT  pendingTable.appUserID, userTable.userName, pendingTable.appCurrentRole, pendingTable.desired_RoleID "
    				+ "FROM pending pendingTable, users userTable "
    				+ "WHERE userTable.userID = pendingTable.appUserID";
    		ResultSet rs2 = myConnection.createStatement().executeQuery(getAllPendingUsertoTableLoadQuery);
    		while(rs2.next())
    		{
    			data.add(new TableViewController(rs2.getInt("pendingTable.appUserID"),rs2.getString("userTable.userName"),rs2.getInt("pendingTable.appCurrentRole"),rs2.getInt("pendingTable.desired_RoleID")));
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    		System.out.println("ERROR @ Controller.pendingUsersToTableView");
    	}
    	pendingColumnUserID.setCellValueFactory(new PropertyValueFactory<>("pendingTable.appUserID"));
    	pendingColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userTable.userName"));
    	pendingColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("pendingTable.appCurrentRole"));
    	pendingColumnDesiredRole.setCellValueFactory(new PropertyValueFactory<>("pendingTable.desired_RoleID"));
    	userPendingTable.setItems(data);
    }
@FXML
private void goBackToSpect(ActionEvent event) throws Exception
    {
    	spectGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/spectatorLanding.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	stage.show();
    	System.gc();
     }
@FXML
private void goBackToApp(ActionEvent event) throws Exception
    {
    	confGoBackButton.getScene().getWindow().hide();
    	loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
    	scene = new Scene(loader.load());
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    	stage.setTitle("Arena");
    	pendingUsersToTableLoad();
    	stage.show();
    	System.gc();
     }
@FXML
private void appChoice(ActionEvent event) throws Exception
    {
    	appOperatorButton.getScene().getWindow().hide();
        loader.setLocation(getClass().getResource("/arenaViews/appConfPage.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
        stage.setTitle("Arena");
        stage.show();
    }
@FXML
private void showRoleDetails(MouseEvent event) throws IOException
    {
    	appOperatorDetails.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
@FXML
private void hideRoleDetails(MouseEvent event) throws IOException
    {
    	appOperatorDetails.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
@FXML
private void showLoRoleDetails(MouseEvent event) throws IOException
    {
    	appLeagueOwnerDetails.setVisible(true);
    	appLeagueOwnerDetails1.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
@FXML
private void hideLoRoleDetails(MouseEvent event) throws IOException
    {
    	appLeagueOwnerDetails.setVisible(false);
    	appLeagueOwnerDetails1.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
@FXML
private void showPlayerRoleDetails(MouseEvent event) throws IOException
    {
    	appPlayerDetails.setVisible(true);
    	appPlayerDetails1.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
@FXML
private void hidePlayerRoleDetails(MouseEvent event) throws IOException
    {
    	appPlayerDetails.setVisible(false);
    	appPlayerDetails1.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
@FXML
private void showAdvertRoleDetails(MouseEvent event) throws IOException
    {
    	appAdvertDetails.setVisible(true);
    	noRoleSelectedLabel.setVisible(false);
    }
@FXML
private void hideAdvertRoleDetails(MouseEvent event) throws IOException
    {
    	appAdvertDetails.setVisible(false);
    	noRoleSelectedLabel.setVisible(true);
    }
@FXML
private void goToCreateTournamentsView (ActionEvent event) throws Exception
 {
 	 leagueOwnerGoToCreateTournsButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/CreateTournaments.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
 }
 @FXML
private void goToTournMang(ActionEvent event) throws Exception
{
	leagueOwnerGoToManageTournsButton.getScene().getWindow().hide();
    loader.setLocation(getClass().getResource("/arenaViews/ManageTournaments.fxml"));
    scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setResizable(false);
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    stage.setTitle("Arena");
    stage.show();
    System.gc();
}
 @FXML
private void goToMangUsers(ActionEvent event) throws Exception
{
    opManageUsersButton.getScene().getWindow().hide();
    loader.setLocation(getClass().getResource("/arenaViews/operatorManageUsersPage.fxml"));
    scene = new Scene(loader.load());
    stage.setScene(scene);
    stage.setResizable(false);
    stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
    stage.setTitle("Arena");
    stage.show();
    System.gc();
}
@FXML
private void opGoToCreateArenas(ActionEvent event) throws IOException, SQLException
 {
 	 opCreateArenasButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/CreateArena.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
 }
@FXML
private void opGoToManageArenas(ActionEvent event) throws IOException, SQLException
 {
 	opManageArenaButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/ManageArena.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
 }
@FXML
private void goToGuestLanding(ActionEvent event) throws IOException, SQLException
 {
 	 GuestButton.getScene().getWindow().hide();
     loader.setLocation(getClass().getResource("/arenaViews/GuestLanding.fxml"));
     scene = new Scene(loader.load());
     stage.setScene(scene);
     stage.setResizable(false);
     stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
     stage.setTitle("Arena");
     stage.show();
     System.gc();
 }
ArenaController arenaController = new ArenaController();
@FXML
private void appOpChoice(MouseEvent event) throws IOException
  {
  	appRoleChoice = 0;
  }
@FXML
private void appLoChoice(MouseEvent event) throws IOException
  {
  	appRoleChoice = 1;
  }
@FXML
private void appPlChoice(MouseEvent event) throws IOException
  {
  	appRoleChoice = 3;
  }
@FXML
private void appAdChoice(MouseEvent event) throws IOException
  {
  	appRoleChoice = 2;
  }
@FXML
private void confYes(ActionEvent event) throws SQLException, IOException
  {
  	Connection myConnection = DBHandler.getConnection();
  	if(appRoleChoice == 0)
  	{
  		String confYesInsert = "INSERT INTO pending (appUserID,appCurrentRole,desired_RoleID)"
      			+ " VALUES("+currUserID+","+currRoleID+","+appRoleChoice+")";
  		try
  		{
  			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
  			preparedStatement.execute(confYesInsert);
  		}
  		catch(SQLException e)
  		{
  			e.printStackTrace();
  			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 0");
  		}
  		finally
  		{
  			myConnection.close();
  		}
  	}
  	if(appRoleChoice == 1)
  	{
  		String confYesInsert = "INSERT INTO pending (appUserID,appCurrentRole,desired_RoleID)"
      			+ " VALUES("+currUserID+","+currRoleID+","+appRoleChoice+")";
  		try
  		{
  			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
  			preparedStatement.execute(confYesInsert);
  		}
  		catch(SQLException e)
  		{
  			e.printStackTrace();
  			System.out.println("ERROR: AT Controller.confYes.appRoleChoie 1");
  		}
  		finally
  		{
  			myConnection.close();
  		}
  	}
  	if(appRoleChoice == 2)
  	{
  		String confYesInsert ="UPDATE arenadatabase.users SET userRoleID = ? WHERE userID = ?";
  		try
  		{
  			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
  			preparedStatement.setInt(1,appRoleChoice);
  			preparedStatement.setInt(2, currUserID);
  			preparedStatement.executeUpdate();
  		}
  		catch(SQLException e)
  		{
  			e.printStackTrace();
  			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 2");
  		}
  		finally
  		{
  			myConnection.close();
  		}
  	}
  	if(appRoleChoice == 3)
  	{
  		String confYesInsert ="UPDATE arenadatabase.users SET userRoleID = ? WHERE userID = ?";
  		try
  		{
  			PreparedStatement preparedStatement = myConnection.prepareStatement(confYesInsert);
  			preparedStatement.setInt(1,appRoleChoice);
  			preparedStatement.setInt(2, currUserID);
  			preparedStatement.executeUpdate();
  		}
  		catch(SQLException e)
  		{
  			e.printStackTrace();
  			System.out.println("ERROR: AT Controller.confYes.appRoleChoice 3");
  		}
  		finally
  		{
  			myConnection.close();
  		}
  	}
  	confYesButton.getScene().getWindow().hide();
  	loader.setLocation(getClass().getResource("/arenaViews/loginPage.fxml"));
  	sceneLogin = new Scene(loader.load());
  	stage.setScene(sceneLogin);
  	stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
  	stage.setTitle("Arena");
  	stage.setResizable(false);
  	stage.show();
  }
@FXML
private void confNo(ActionEvent event) throws IOException
  {
      confGoBackButton.getScene().getWindow().hide();
      loader.setLocation(getClass().getResource("/arenaViews/spectAppPage.fxml"));
      scene = new Scene(loader.load());
      stage.setScene(scene);
      stage.setResizable(false);
      stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
      stage.setTitle("Arena");
      stage.show();
  }
@FXML
private void approveNewUser(ActionEvent event) throws SQLException
  {
  	Connection myConnection = DBHandler.getConnection();
  	TableViewController userData = userPendingTable.getSelectionModel().getSelectedItem();
  	userData.setAppCurrentRole(appRoleChoice);
  	int selectedDesiredRole = userData.getdesired_RoleIDNew();
  	int selectedUserID = userData.getAppUserID();
  	String sqlUpdateTwo ="UPDATE arenadatabase.users SET userRoleID = "+selectedDesiredRole+" WHERE users.userID = "+selectedUserID;
  	String sqlUpdate = "DELETE FROM arenadatabase.pending WHERE pending.appUserID ="+selectedUserID+"";
  	try
  	{
  		pst = myConnection.prepareStatement(sqlUpdate);
  		pstTwo = myConnection.prepareStatement(sqlUpdateTwo);
  	}
  	catch(SQLException e)
  	{
  		e.printStackTrace();
  		System.out.println("ERROR @ Control.approveNewUser");
  	}
  	try
  	{
  		pst.executeUpdate();
  		pstTwo.execute(sqlUpdateTwo);
  		pendingUsersToTableLoad();
  	}
  	catch(SQLException e)
  	{
  		e.printStackTrace();
  		System.out.println("ERROR @ Control.approveNewUser");
  	}
  	finally
  	{
  		myConnection.close();
  	}
  }
@FXML
private void denyNewUser(ActionEvent event) throws SQLException
  {
      Connection myConnection = DBHandler.getConnection();
      TableViewController userData = userPendingTable.getSelectionModel().getSelectedItem();
      userData.setAppCurrentRole(appRoleChoice);
      int selectedUserID = userData.getAppUserID();
      String sqlUpdateThree = "DELETE FROM arenadatabase.pending WHERE pending.appUserID ="+selectedUserID+"";
      try
      {
      	pstTwo = myConnection.prepareStatement(sqlUpdateThree);
      }
      catch(SQLException e)
      {
          e.printStackTrace();
          System.out.println("ERROR @ Control.approveNewUser");
      }
      try
      {
      	pstTwo.execute(sqlUpdateThree);
      	pendingUsersToTableLoad();
      }
      catch(SQLException e)
      {
          e.printStackTrace();
          System.out.println("ERROR @ Control.approveNewUser");
      }
      finally
      {
      	myConnection.close();
      }
      }
@FXML
private void ManageUsersToTableView(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data2 = FXCollections.observableArrayList();
		try
		{
			ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT userID, userName, userRoleID FROM users");
			while(rs3.next())
			{
				data2.add(new ManageUsersController(rs3.getInt("userID"),rs3.getString("userName"),rs3.getInt("userRoleID")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Controller.ManageUsersToTableView");
		}
		manageUsersColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		manageUsersColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		manageUsersColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("userRoleID"));
		manageUsersTable.setItems(data2);
	}
private void JustDoManageUsersToTableView() throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		data2 = FXCollections.observableArrayList();
		try
		{
			ResultSet rs3 = myConnection.createStatement().executeQuery("SELECT userID, userName, userRoleID FROM users");
			while(rs3.next())
			{
				data2.add(new ManageUsersController(rs3.getInt("userID"),rs3.getString("userName"),rs3.getInt("userRoleID")));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Controller.ManageUsersToTableView");
		}
		manageUsersColumnUserID.setCellValueFactory(new PropertyValueFactory<>("userID"));
		manageUsersColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		manageUsersColumnCurrentRole.setCellValueFactory(new PropertyValueFactory<>("userRoleID"));
		manageUsersTable.setItems(data2);
	}
@FXML
private void removeUser(ActionEvent event) throws SQLException
	{
		Connection myConnection = DBHandler.getConnection();
		ManageUsersController userData2 = manageUsersTable.getSelectionModel().getSelectedItem();
		int selectedUserID = userData2.getUserID();
		String sqlUpdateThree = "DELETE FROM arenadatabase.users WHERE users.userID =" +selectedUserID +"";
		try
		{
			pstTwo = myConnection.prepareStatement(sqlUpdateThree);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser.First Try");
		}
		try
		{
			pstTwo.execute(sqlUpdateThree);
			JustDoManageUsersToTableView();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("ERROR @ Control.removeUser. 2nd Try");
		}
		finally
		{
			myConnection.close();
		}
	}
@FXML
private void goToPlayerManagement(ActionEvent event) throws Exception {
      	  leagueOwnerGoToManagePlayers.getScene().getWindow().hide();
          loader.setLocation(getClass().getResource("/arenaViews/LeagueOwnerManageUsersPage.fxml"));
          scene = new Scene(loader.load());
          stage.setScene(scene);
          stage.setResizable(false);
          stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/arenaIcon.png")));
          stage.setTitle("Arena");
          stage.show();
          System.gc();
          }
}
