package com.example.taskmanagement;

import com.example.taskmanagement.HomeWorkTask;
import com.example.taskmanagement.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TaskManagementController {
    @FXML
    private ListView<Task> listView;
    ObservableList<Task> tasks = FXCollections.observableArrayList();

    public void initialize() {
        // Initialize the ListView
        listView.setItems(tasks);
    }

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputDesc;

    @FXML
    private Label label;

    @FXML
    protected void onListViewSelected(){
        int i = listView.getSelectionModel().getSelectedIndex();
        label.setText(""+i);

        HomeWorkTask ht = (HomeWorkTask) tasks.get(i);

        inputName.setText(ht.getTaskName());
        inputDesc.setText(ht.getDescription());


    }


    @FXML
    protected void onSaveButtonClick(){
        HomeWorkTask ht = new HomeWorkTask() {
            @Override
            public void setTask(String taskName, String taskDescription) {

            }
        };
        ht.createTask(inputName.getText(), inputDesc.getText());
        tasks.add(ht);
    }

    @FXML
    protected void onDeleteButtonClick() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
        }
    }



}