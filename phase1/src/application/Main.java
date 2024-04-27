package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	DoubleLinkedlist list2 = new DoubleLinkedlist();
	Martyr martyr = new Martyr();
	RadioButton rbtn1, rbtn2, rbtn3, rbtn4;
	Label lbl3;
	TextField txt3, txtf;
	Button btn2, next, btnNext, btnPrev;
	ArrayList<String> array = new ArrayList();
	Stage primaryStage;
	Node n;
	Notifcations note = new Notifcations();
	TextArea ta3, ta;
	ComboBox<String> cbox;

	@Override
	public void start(Stage primaryStage) {
		// to read from file
		Label title = new Label("Welcome To The Country Of The Martyrs ");
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 30));
		Image m = new Image("C:\\Users\\user\\Desktop\\Afnan\\phase1\\src\\projectimage.png");
		ImageView img = new ImageView(m);
		Button btn1 = new Button("Get The Data From File");
		btn1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 10));
		btn1.setOnAction(e -> {
			readFromFile();

		});

		img.setFitHeight(600);
		img.setFitWidth(600);
		next = new Button("Next");
		next.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 10));
		next.setOnAction(e -> {
			primaryStage.close();
			stage2();

		});
		VBox vBox = new VBox(30);
		vBox.getChildren().addAll(title, img, btn1, next);
		vBox.setStyle("-fx-background:RED");
		vBox.setAlignment(Pos.CENTER);
		Scene scene1 = new Scene(vBox, 800, 800);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
	// this Method to Read the File
	public void readFromFile() {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*"));
		File selectedFile = chooser.showOpenDialog(primaryStage);
		SimpleDateFormat Format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Scanner scan = new Scanner(selectedFile);
			String line;
			while (scan.hasNext()) {
				line = scan.nextLine();
				String[] token = line.split(",");
				String name = token[0];
				int age = Integer.parseInt(token[1]);
				String location = token[2];
				Date date2 = Format.parse(token[3]);
				char gender = (token[4].charAt(0));
				Location location2 = new Location();
				location2.setLocation(location);
				Node node = list2.search(location2);
				if (node == null) {
				// this condition to check if the location is exist or not
					list2.insertAndSort(location2);
					list2.search(location2).list.addAndSort(martyr);
					array.add(location);
					System.out.println(location);

				} else {
					node.getList().addAndSort(martyr);

				}
			}
			scan.close();
		} catch (FileNotFoundException e1) {
			System.out.println(" the file is not found");
		} catch (NumberFormatException e2) {
			System.out.println("there's no age found for someone");
		} catch (ParseException e3) {
			System.out.println("There's a wrong date");
		}

	}

//stage contians a tabs
	public void stage2() {
		Stage stage2 = new Stage();
		TabPane tabs = new TabPane();
		Tab tab1 = new Tab("Location");
		Tab tab2 = new Tab("Martyrs");
		Tab tab3 = new Tab("Statistics");
		Tab tab4 = new Tab("Save");
		Tab tab5 = new Tab("Seach");
		tabs.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);
		tab1.setContent(tapOne());
		tab2.setContent(tabTwo());
		tab3.setContent(tabThree());
		 tab4.setContent(tabFour());
		tab5.setContent(tapFive());
		VBox vBox2 = new VBox(tabs);
		Scene s2 = new Scene(vBox2, 800, 800);
		stage2.setScene(s2);
		tabs.setStyle("-fx-background:LIGHTGREY");
		stage2.showAndWait();
	}

//tab2 is contains a martyr information
	public BorderPane tabTwo() {
		BorderPane pane = new BorderPane();
		GridPane gpane = new GridPane();
		RadioButton rbtn1 = new RadioButton("insert");
		RadioButton rbtn2 = new RadioButton("update");
		RadioButton rbtn3 = new RadioButton("Delete");
		RadioButton rbtn4 = new RadioButton("Search");
		gpane.addRow(0, rbtn1, rbtn2, rbtn3, rbtn4);
		ToggleGroup group = new ToggleGroup();
		Label lbl1 = new Label("Name");
		Label lbl2 = new Label("age");
		Label lbl4 = new Label("Date of Death");
		Label lbl5 = new Label("Gender");
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		rbtn1.setToggleGroup(group);
		rbtn2.setToggleGroup(group);
		rbtn3.setToggleGroup(group);
		rbtn4.setToggleGroup(group);
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		TextField txt5 = new TextField();
		txt1.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt5.setVisible(false);
		Button btn2 = new Button("insert");
		btn2.setVisible(false);
		gpane.addRow(1, lbl1, txt1);
		gpane.addRow(2, lbl2, txt2);
		gpane.addRow(3, lbl4, txt3);
		gpane.addRow(4, lbl5, txt5);
		gpane.addRow(5, btn2);
		gpane.setHgap(20);
		gpane.setVgap(20);
		gpane.setAlignment(Pos.CENTER);
		rbtn1.setOnAction(e -> {
			if (rbtn1.isSelected())
				lbl1.setVisible(true);
			lbl2.setVisible(true);
			lbl4.setVisible(true);
			lbl5.setVisible(true);
			txt1.setVisible(true);
			txt2.setVisible(true);
			txt3.setVisible(true);
			txt5.setVisible(true);
			btn2.setVisible(true);
		});
		pane.setCenter(gpane);
		btn2.setOnAction(e -> {
			SimpleDateFormat Format = new SimpleDateFormat("MM/dd/yyyy");
			try {
				list2.search(new Location(cbox.getValue())).getList().addAndSort(new Martyr(txt1.getText(),
						Integer.parseInt(txt2.getText()), Format.parse(txt3.getText()), txt5.getText().charAt(0)));
				note.massege(" ", "Dear user:Add This  to List Done Successsful");
			} catch (NumberFormatException e1) {

				e1.printStackTrace();
			} catch (Exception e1) {
				note.no("!!", "please check the text filed agian");
			}
		});
		TextField txtu11 = new TextField();
		txtu11.setVisible(false);
		TextField txtu22 = new TextField();
		txtu22.setVisible(false);
		TextField txtu33 = new TextField();
		txtu33.setVisible(false);
		TextField txtu44 = new TextField();
		txtu44.setVisible(false);
		TextField txtu55 = new TextField();
		txtu55.setVisible(false);
		TextField txtu66 = new TextField();
		txtu66.setVisible(false);
		TextField txtu77 = new TextField();
		txtu77.setVisible(false);
		TextField txtu88 = new TextField();
		txtu88.setVisible(false);
		Button btn3 = new Button("update");
		btn3.setVisible(false);
		gpane.addColumn(2, txtu11, txtu22, txtu33, txtu44);
		gpane.addColumn(3, txtu55, txtu66, txtu77, txtu88);
		gpane.add(btn3, 3, 6);
		rbtn2.setOnAction(e -> {
			txtu11.setVisible(true);
			txtu22.setVisible(true);
			txtu33.setVisible(true);
			txtu44.setVisible(true);
			txtu55.setVisible(true);
			txtu66.setVisible(true);
			txtu77.setVisible(true);
			txtu88.setVisible(true);
			btn3.setVisible(true);
		});
		btn3.setOnAction(e -> {
			SimpleDateFormat Format = new SimpleDateFormat("MM/dd/yyyy");
			Linkedlist list1 = list2.search(new Location(cbox.getValue())).getList();
			try {
				if (list1.searchList(new Martyr(txtu11.getText(), Integer.parseInt(txtu22.getText()),
						Format.parse(txtu33.getText()), txtu44.getText().charAt(0))) != null) {
					list1.remove(new Martyr(txtu11.getText(), Integer.parseInt(txtu22.getText()),
							Format.parse(txtu33.getText()), txtu44.getText().charAt(0)));
					list1.addAndSort(new Martyr(txtu55.getText(), Integer.parseInt(txtu66.getText()),
							Format.parse(txtu77.getText()), txtu88.getText().charAt(0)));
					note.massegeu(" ", "update done successfully");
					txtu11.clear();
					txtu22.clear();
					txtu33.clear();
					txtu44.clear();
					txtu55.clear();
					txtu66.clear();
					txtu77.clear();
					txtu88.clear();
				} else {
					note.dMartyr(" ", "Dear User This Martye not vaild in your list");
					txtu11.clear();
					txtu22.clear();
					txtu33.clear();
					txtu44.clear();
					txtu55.clear();
					txtu66.clear();
					txtu77.clear();
					txtu88.clear();
				}
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				note.no(" ", "Try Again");
			}

		});
		TextField txtd = new TextField();
		txtd.setVisible(false);
		Button btn4 = new Button("Delete");
		btn4.setVisible(false);

		rbtn3.setOnAction(e -> {
			txtd.setVisible(true);
			btn4.setVisible(true);
		});

		btn4.setOnAction(e -> {
			if (list2.search(new Location(cbox.getValue())).getList().searchList(new Martyr(txtd.getText())) != null) {
				list2.search(new Location(cbox.getValue())).getList().remove(new Martyr(txtd.getText()));
				note.delete(" ", "Dear User Delete done successful in your list");
			} else {
				note.dMartyr(" ", "Dear User This Martye not vaild in your list");

			}
		});
		rbtn4.setOnAction(e -> {
			if (rbtn4.isSelected()) {
				btnSearch();
			}
		});
		gpane.addColumn(4, txtd, btn4);
		gpane.setAlignment(Pos.CENTER);
		gpane.setHgap(10);
		gpane.setVgap(30);
		pane.setCenter(gpane);
		return pane;
	}

	public void btnSearch() {
		GridPane grid = new GridPane();
		TextField txtss = new TextField();
		grid.add(txtss, 1, 1);
		TextArea ta2 = new TextArea();
		grid.add(ta2, 2, 2);
		Button btn5 = new Button("Search");
		grid.add(btn5, 3, 3);
		btn5.setOnAction(e -> {
			ta.clear();
			list2.search(new Location(cbox.getValue())).getList().searhName(txtss.getText());
			if (list2.search(new Location(cbox.getSelectionModel().getSelectedItem())).getList()
					.searhName(txtss.getText()) == null) {
				ta2.setVisible(true);
				ta2.setText("Sorry can't find martyr starting in this name");
			} else {
				ta2.setVisible(true);
				ta2.setText(list2.search(new Location(cbox.getValue())).getList().searhName(txtss.getText())
						.getElement().toString());
			}
		});
		Scene s3 = new Scene(grid, 600, 600);
		Stage Stage3 = new Stage();
		Stage3.setScene(s3);
		Stage3.showAndWait();

	}

	public GridPane tapOne() {

		GridPane gpane = new GridPane();
		RadioButton rbtn1 = new RadioButton("insert");
		RadioButton rbtn2 = new RadioButton("update");
		RadioButton rbtn3 = new RadioButton("Delete");
		RadioButton rbtn4 = new RadioButton("Search");
		gpane.addColumn(1, rbtn1, rbtn2, rbtn3, rbtn4);
		lbl3 = new Label("Location");
		lbl3.setVisible(false);
		txt3 = new TextField();
		txt3.setVisible(false);
		btn2 = new Button("insert");
		btn2.setVisible(false);
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(lbl3, txt3);
		gpane.addRow(0, hbox, btn2);
		rbtn1.setOnAction(e -> {
			if (rbtn1.isSelected())
				lbl3.setVisible(true);
			txt3.setVisible(true);
			btn2.setVisible(true);
		});

		btn2.setOnAction(e -> {
			if (txt3.getText() == null) {
				note.no(" Warning", "Dont make this txt Empty please");
			} else if (txt3.getText() != null) {
				if ((list2.search(new Location(txt3.getText())) == null)) {
					list2.insertAndSort(new Location(txt3.getText()));
					note.massege(" ", "Dear user:Add This Location to List Done Successsful");
					array.add(txt3.getText());
					txt3.clear();

				}
			} else

				note.display("Worning ", "This Location already Exist");

		});

		TextField txtu1 = new TextField();
		TextField txtu2 = new TextField();
		Button btn3 = new Button("update");
		txtu1.setVisible(false);
		txtu2.setVisible(false);
		btn3.setVisible(false);
		gpane.addRow(1, txtu1, txtu2, btn3);
		rbtn2.setOnAction(e -> {
			if (rbtn2.isSelected())
				txtu1.setVisible(true);
			txtu2.setVisible(true);
			btn3.setVisible(true);
		});
		btn3.setOnAction(e -> {
			new Location(txtu1.getText());
			if (list2.search(new Location(txtu1.getText())) == null) {
				note.error(" ", "Dear User This Location unvalid in your list");
			} else
				list2.update(txtu1.getText(), txtu2.getText());
			note.massegeu("  ", "Dear user:update at This Location to List Done Successs");
			array.remove(txt3.getText());
			array.add(txtu2.getText());
			txtu1.clear();
			txtu2.clear();

		});

		TextField txtd = new TextField();
		Button btn4 = new Button("Delete");
		txtd.setVisible(false);
		btn4.setVisible(false);
		gpane.addRow(2, txtd, btn4);
		rbtn3.setOnAction(e -> {
			if (rbtn2.isSelected())
				txtd.setVisible(true);
			btn4.setVisible(true);
		});
		btn4.setOnAction(e -> {
			if (list2.search(new Location(txtd.getText())) == null)
				note.error(" ", "Dear User This Location unvalid in your list");
			else

				list2.removeobj(new Location(txtd.getText()));
			note.delete("  ", "Dear User This Location unvalid in your list");
			array.remove(txtd.getText());
			ObservableList<String> options = FXCollections.observableArrayList(array);
			cbox.setItems(options);
			txtd.clear();
		});
		/*cbox = new ComboBox<String>();
		cbox.setVisible(false);
		ta = new TextArea();
		ta.setVisible(false);
		gpane.addRow(3, cbox, ta);
		ta.setText("");
		rbtn4.setOnAction(e -> {
			cbox.setVisible(true);
			ta.setVisible(true);
		});
		cbox.getItems().addAll(array);
		ObservableList<String> options = FXCollections.observableArrayList(array);
		cbox.setItems(options);
		ta.setVisible(true);
		ta.setText("");
		cbox.setOnAction(e -> {
			String selected = cbox.getValue();
			StringBuilder sb = new StringBuilder();

			if (list.search(new Brand(selected)) == null) {
				sb.append("This brand doesn't contain any cars");
			} else {
				list.textArea(new Brand(selected ));
			}

			ta.setText(sb.toString());
		});*/
		gpane.setAlignment(Pos.CENTER);
		gpane.setHgap(10);
		gpane.setVgap(80);
		return gpane;

	}

	Node current = new Node();
	int count = 0;
	int num = 0;

// this method to show female and male
	
	public String showData(Location obj) {
		current = list2.search(new Location(cbox.getValue()));
		String textShow = " ";
		int sum = 0;
		int mcount = 0;
		int fcount = 0;
		while (current != null) {
			Nodes temp = new Nodes();
			temp = current.getList().getFirst();
			while (temp != null) {
				num++;
				sum += martyr.getAge();
				count++;
				if (martyr.getGender() == 'M') {
					mcount++;
				} else if (martyr.getGender() == 'F') {
					fcount++;
				}
			}
			temp = temp.next;

		}
		current=current.next;

		
		int sum2 = 0;
		double myaverge = 0;
		try {
			sum2 = sum / count;
			myaverge = num / avg();

		} catch (Exception e) {
			System.out.println("cant divd by zero");
		}
		return textShow += ("the number of female:" + fcount + "\n" + "the number of male:" + mcount + "\n"
				+ " the Avarge age in this location" + sum2 + "The percantage of martyr:" + (myaverge) * 100 + "%s");

	}
//this tabs to read from file 
	public GridPane tapFive() {
		GridPane gpane = new GridPane();
		Label lbl = new Label("Write a Martyer Name Please:");
		lbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		txtf = new TextField();
		ta3 = new TextArea();
		ta3.setPrefSize(300, 300);
		gpane.add(lbl, 0, 0);
		gpane.add(txtf, 0, 1);
		gpane.add(ta3, 1, 2);
		gpane.setAlignment(Pos.CENTER);
		Button btn = new Button("search");
		btn.setOnAction(e -> {
			ta3.setText(showData2());
		});

		return gpane;
	}

	public String showData2() {
		String text = " ";
		Node curr = list2.getFirst();
		while (curr != null) {
			curr.getList();
			Nodes temp = curr.getList().getFirst();
			while (temp != null) {
				if (curr.getList().searhName(txtf.getText()) == null) {
					ta3.setVisible(true);
					text += ("Sorry!! Can't Find Martyr Name");
				} else if (curr.getList().searhName(txtf.getText()) != null)
					ta3.setVisible(true);
				text += (curr.getList().searhName(txtf.getText()).element.getName() + curr.element.getLocation());
				temp = temp.next;
			}

			curr = curr.next;
		}
		return text;
	}
//this method contians a statistic
	public GridPane tabThree() {
		TextArea ta4 = new TextArea();
		GridPane gpane = new GridPane();
		gpane.add(ta4, 1, 1);
		gpane.add(btnPrev, 1, 2);
		btnPrev = new Button("prev");
		gpane.add(btnNext, 0, 2);
		btnNext = new Button("next");
		
		 Button preNext = new Button("Previos"); 
		 btnNext.setOnAction(e -> { 
			 current =current.next; });
		 
		StringBuilder bulid = new StringBuilder();
		bulid.append(showData(new Location(cbox.getValue())));
		ta4.setText(bulid.toString());
		return gpane;
	}

	public VBox tabFour() {
		Label lblsave = new Label("To save you Data in file Please Dear user Click to button");
		lblsave.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		Button btnSave = new Button("Click");
		btnSave.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		btnSave.setOnAction(e -> {
			showtheFile();
		});
		VBox vbox1 = new VBox(50);
		vbox1.getChildren().addAll(lblsave, btnSave);
		return vbox1;

	}
	
//this method to make print Writer
	public void showtheFile() {
		FileChooser chooser = new FileChooser();
		FileChooser.ExtensionFilter textFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
		chooser.getExtensionFilters().add(textFilter);
		chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.txt", "*.*"));
		File selectedFile = chooser.showOpenDialog(primaryStage);
			try {
				PrintWriter print=new PrintWriter(selectedFile);
				Node curr = list2.getFirst();
				while (curr != null) {
					Linkedlist xlist = curr.getList();
					Nodes temp = xlist.getFirst();
					while (temp != null) {

						String data = " ";
						print.write(temp.element.getName() + "," + temp.element.getAge() + "," + curr.element.getLocation()
								+ "," + (temp.getElement().getDateOfDeath().getYear() + 1900) + "/"
								+ (temp.element.getDateOfDeath().getMonth() + 1) + "/"
								+ (temp.element.getDateOfDeath().getDay()) + "," + temp.getElement().getGender()
								+ "\n");
						
					}
					temp = temp.next;
				}
				curr = curr.next;

				print.flush();

			} catch (FileNotFoundException e) {
				System.out.println("cant find file");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
// to count the number of Martyrs
	public double avg() {
		current = list2.getFirst();
		String textShow = " ";
		int sum = 0;
		while (current != null) {
			Nodes temp = new Nodes();
			temp = current.getList().getFirst();
			while (temp != null) {
				sum++;

			}
			temp = temp.next;

		}
		current = current.next;

		return sum;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
