package edu.macalester.comp124.hw4;

/**
 * Displays a single web page with a max character length
 * .
 * @author shilad, Bret
 */
public class Tab {
	private String url;

	/**
	 * Constructor
	 */
	public Tab() {
		url = null;
	}

	/**
	 * Get the url for the tab
	 * @return url of the tab
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the URL for the tab
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Returns a string that contains the url of the tab.
	 * @return url of the tab
	 */
	public String toString(){
		return (url);
	}

	/**
	 * Checks if two tabs are equal by comparing their urls.
	 * @param obj
	 * @return true if two tabs are equal.
	 */
	public boolean equals(Object obj){
		if (obj == null || !(obj instanceof Tab)){
			return false;
		}

		Tab tab = (Tab) obj;
		return (this.url.equals(tab.url));
	}

}
