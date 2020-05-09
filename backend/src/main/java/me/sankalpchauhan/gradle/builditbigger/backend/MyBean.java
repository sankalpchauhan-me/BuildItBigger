package me.sankalpchauhan.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints
 *  Was Included with the udacity starter code provided in project instructions
 * */
public class MyBean {

    private String myData;
    public String getData() {
        return myData;
    }
    public void setData(String data) {
        myData = data;
    }
}