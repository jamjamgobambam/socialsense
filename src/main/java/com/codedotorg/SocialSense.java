package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SocialSense {

    /** The text box that displays the results */
    private TextArea results;

    /** The list of positive words */
    private ArrayList<String> positiveWords;

    /** The list of negative words */
    private ArrayList<String> negativeWords;

    /** The label to tell the user where to type */
    private Label inputLabel;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructor for the SocialSense class.
     * 
     * Initializes the TextArea for results with word wrap enabled.
     * Initializes the positive and negative word lists by calling the respective methods.
     * Initializes the label for the input field with the text "Enter the post:".
     * Initializes the TextField for user input.
     */
    public SocialSense() {
        results = new TextArea();
        results.setWrapText(true);

        positiveWords = createPositiveWords();
        negativeWords = createNegativeWords();

        inputLabel = new Label("Enter the post:");
        inputField = new TextField();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage and shows the main scene.
     *
     * @param primaryStage This is the primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("SocialSense");
        showMainScene(primaryStage);
    }

    /**
     * Displays the main scene of the application.
     * It sets the action for the input field, creates the layout for the scene,
     * and then sets and shows the scene on the provided primary stage.
     *
     * @param primaryStage The primary stage on which the scene is to be shown.
     */
    public void showMainScene(Stage primaryStage) {
        setInputFieldAction();

        HBox inputLayout = new HBox(inputLabel, inputField);
        VBox layout = new VBox(results, inputLayout);
        Scene mainScene = new Scene(layout, 300, 200);
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Analyzes the sentiment of a given input string.
     * It splits the input string into words and checks each word against a list of
     * positive and negative words. If a word is found in the positive words list,
     * the positive count is incremented. If a word is found in the negative words
     * list, the negative count is incremented. After all words have been checked,
     * the method returns "Positive" if there are more positive words, "Negative" if
     * there are more negative words, and "Neutral" if the counts are equal.
     *
     * @param input The string to be analyzed.
     * @return A string indicating the overall sentiment ("Positive", "Negative", or "Neutral").
     */
    public String analyzeSentiment(String input) {
        
        return "";
    }

    /**
     * Creates an ArrayList of positive words.
     * 
     * @return ArrayList<String> - Returns an ArrayList containing positive words.
     */
    private ArrayList<String> createPositiveWords() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("good");
        temp.add("great");
        temp.add("awesome");
        temp.add("fantastic");
        temp.add("excellent");

        return temp;
    }

    /**
     * Creates a list of negative words.
     * 
     * @return ArrayList<String> This returns the list of negative words.
     */
    private ArrayList<String> createNegativeWords() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("bad");
        temp.add("terrible");
        temp.add("awful");
        temp.add("horrible");

        return temp;
    }

    /**
     * Sets an action on the input field. When an action is performed on the input
     * field (typically when the user presses Enter), the method does the following:
     * 1. It retrieves the text from the input field.
     * 2. It appends the text to the results text area, prefixed with "Post: ".
     * 3. It analyzes the sentiment of the input text and appends the sentiment to
     *    the results text area, prefixed with "Sentiment: ".
     * 4. It clears the input field for the next input.
     */
    private void setInputFieldAction() {
        inputField.setOnAction(event -> {
            String input = inputField.getText();
            results.appendText("Post: " + input + "\n");
            String sentiment = analyzeSentiment(input);
            results.appendText("Sentiment: " + sentiment + "\n");
            inputField.clear();
        });
    }
    
}
