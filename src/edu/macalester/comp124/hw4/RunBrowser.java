package edu.macalester.comp124.hw4;

import acm.program.ConsoleProgram;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;


/**
 * Runs the a text-based user interface for a browser.
 * Created by bjackson
 */
public class RunBrowser extends ConsoleProgram {

    private Browser browser;
    private WebEngine engine;

    // Possible interaction options, could also use an enum
    public static final String OPEN = "open";
    public static final String LIST = "list";
    public static final String NEW = "new";
    public static final String SWITCH = "switch";
    public static final String QUIT = "quit";

    /**
     * Initializes the instance variables.
     */
    public void init() {
        browser = new Browser(engine);

        JFXPanel jfxPanel = new JFXPanel();
        Platform.runLater(() -> { // WebView javaFX components need to be managed by JavaFX
            WebView webView = new WebView();
            webView.setPrefWidth(1200);
            webView.setPrefHeight(600);
            engine = webView.getEngine();
            //webView.getEngine().loadContent("<html> Hello World!</html>");
            jfxPanel.setScene(new Scene(webView));
            browser.setWebEngine(engine);

            engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    SwingUtilities.invokeLater( () -> {
                        System.out.println("Loading (%): "+newValue.toString());
                    });
                }
            });

            engine.getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>() {
                @Override
                public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {
                    if(engine.getLoadWorker().getState() == Worker.State.FAILED){
                        SwingUtilities.invokeLater( () -> {
                            System.out.println("Error: \n"+newValue.getMessage());
                        });
                    }
                }
            });

        });
        add(jfxPanel, NORTH);
    }

    /**
     * Normal run method
     */
    public void run() {
        setSize(1200, 1000);

        while(true) {
            String menu = readLine("Enter command (new, list, switch, open, quit): ");
            if (menu.equals(NEW)) {
                String url = readLine("Enter url: ");
                browser.newTab(url);
            } else if (menu.equals(LIST)) {
                print(browser.printList());
            } else if (menu.equals(OPEN)) {
                String url = readLine("Enter url: ");
                browser.open(url);
            } else if (menu.equals(SWITCH)) {
                int tabIndex = browser.getNumTabs() - 1;
                int tab = readInt("Enter the tab to display (from o to " + tabIndex + "): ");
                browser.switchTab(tab);
            } else if (menu.equals(QUIT)) {
                browser.quit();
            }
        }

    }


}
