/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package apiexampleclient;

import APIExampleClient.APIExampleClient;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpURLConnectionExample {

	private static final String GET_URL = "http://localhost:8080/APIExample-Server/resources/HelloWorld";

	private static final String POST_URL = "http://localhost:8080/APIExample-Server/resources/com.mycompany.apiexample.server.users";

	private static final String POST_PARAMS = "NivNaim";            
    
        private static final String type = "application/x-www-form-urlencoded";
                
        //private static final String encodedData = URLEncoder.encode(POST_PARAMS, "UTF-8");
        
	public static void main(String[] args) throws IOException {

		sendGET();
		System.out.println("GET DONE");
		//sendPOST();
		//System.out.println("POST DONE");
	}

	private static void sendGET() throws MalformedURLException, ProtocolException, IOException{
        
        URL url = new URL(POST_URL);
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();    
        BufferedReader br;
        String line;
        StringBuilder responseContent = new StringBuilder();
        
        try {            
            //Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            System.out.println(status);
            
            if(status > 299){
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = br.readLine()) != null){
                    responseContent.append(line);
                }
                br.close();
            } else{
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = br.readLine()) != null){
                    responseContent.append(line);
                }
                br.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(APIExampleClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(APIExampleClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            connection.disconnect();
        }
    }
		
        /*private static void sendPOST() throws IOException {
            URL obj = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", type);
            
            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                                    con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                    }
                    in.close();

                    // print result
                    System.out.println(response.toString());
            } else {
                    System.out.println("POST request not worked");
            }	
        }*/

}
