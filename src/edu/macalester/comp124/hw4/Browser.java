package edu.macalester.comp124.hw4;

import acm.program.ConsoleProgram;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.lang.management.PlatformLoggingMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A browser maintains a set of tabs.
 * @author shilad, Bret
 */
public class Browser {
	private List<Tab> tabs = new ArrayList<Tab>();
	private int displayedIndex = -1;

	private WebEngine webEngine;

	/**
	 * Default constructor.
	 */
	public Browser(WebEngine webEngine) {
		this.webEngine = webEngine;
	}

	/**
	 * Sets the webengine used to load the html webpages
	 * @param engine
	 */
	public void setWebEngine(WebEngine engine){
		this.webEngine = engine;
	}
	
	/**
	 * Adds a new tab and makes it the current tab.
	 * @param tab
	 */
	public void addTab(Tab tab) {
		this.tabs.add(tab);
		displayedIndex = this.tabs.size() - 1;
        loadURL(tab.getUrl());
	}
	
	/**
	 * Makes the current tab the i'th tab (i is 0-indexed).
	 * @param i
	 */
	public void setDisplayedTab(int i) {
		displayedIndex = i;
		Tab t = getDisplayedTab();
		loadURL(t.getUrl());
	}

	/**
	 * Returns the current tab.
	 * @return
	 */
	public Tab getDisplayedTab() {
		return getTab(displayedIndex);
	}
	
	/**
	 * Returns the index of the current tab.
	 * @return
	 */
	public int getDisplayedTabIndex() {
		return displayedIndex;
	}
	
	/**
	 * Returns the i'th tab (i is 0-indexed).
	 * @param i
	 * @return
	 */
	public Tab getTab(int i) {
		return tabs.get(i);
	}
	
	/**
	 * Returns the number of tabs for the browser.
	 * @return
	 */
	public int getNumTabs() {
		return tabs.size();
	}


	/**
	 * Loads a url in the WebView
	 * @param url
	 */
	private void loadURL(final String url){
		if (webEngine != null) {
			Platform.runLater(() -> {
				String tmp = toURL(url);
				if (tmp == null) {
					tmp = toURL("http://" + url);
				}
				webEngine.load(tmp);
			});
		}
	}

	/**
	 * Checks that url is well-formed.
	 * @param url
	 * @return
	 */
	private String toURL(String url){
		try {
			return new URL(url).toExternalForm();
		} catch (MalformedURLException exception){
			return null;
		}
	}

	/**
	 * Opens a new tab with the given url
	 * @param url
	 */
	public void newTab(String url){
		Tab tab = new Tab();
		tab.setUrl(url);
		addTab(tab);
	}

	/**
	 * Prints a list of all the tabs opened
	 * @return
	 */
	public String printList(){
		StringBuilder out = new StringBuilder();
		out.append("==================");
		out.append("All tabs: ");
		out.append("\n");
		for (int i = 0; i < getNumTabs(); i++){
			out.append("Tab " + i + ":" + getTab(i).getUrl());
			out.append("\n");
		}
		out.append("==================");
		return (out.toString());
	}

	/**
	 * Opens the given url within the current tab
	 * @param url
	 */
	public void open(String url){
		int displayedIndex = getDisplayedTabIndex();
		Tab t = getDisplayedTab();
		t.setUrl(url);
		loadURL(t.getUrl());
	}

	/**
	 * Switch to the tab at the given index
	 * @param i
	 */
	public void switchTab(int i){
		setDisplayedTab(i);
	}

	/**
	 * Closes the window and quits the program
	 */
	public void quit(){
		System.exit(0);
	}

	/**
	 * Checks if two browsers are equal by comparing if they have the same list of tabs opened
	 * and if they have the same webEngine.
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj){
		if (obj == null || !(obj instanceof Browser)){
			return false;
		}

		Browser browser = (Browser) obj;
		return (this.tabs.equals(browser.tabs) && this.webEngine.equals(browser.webEngine));
	}

	/**
	 * Prints the list of tabs in the browser
	 * @return
	 */
	public String toString(){
		return(printList());
	}

}
