package mypackage;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class studentServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private studentDao studentDao;

    public void init() {
        studentDao = new studentDao();
    }
    public String encrypt(String plainText) {
    	String allLetters = "abcdefghijklmnopqrstuvwxyzABCDEFGHI" + "JKLMNOPQRSTUVWXYZ" + "0987654321";
   	 
        // create a dictionary to store the substitution for the given alphabet in the plain text based on the key
        Map<Character, Character> dict1 = new HashMap<>();
        int key = 4;
        for (int i = 0; i < allLetters.length(); i++) {
            dict1.put(allLetters.charAt(i),
                    allLetters.charAt((i + key) % allLetters.length()));
        }
 
        StringBuilder cipherText = new StringBuilder();
 
        // loop to generate ciphertext
        for (char c : plainText.toCharArray()) {
            if (allLetters.indexOf(c) != -1) {
                cipherText.append(dict1.get(c));
            } else {
                cipherText.append(c);
            }
        }
        
        System.out.println("Cipher Text is: " + cipherText);
 
        // create a map to store the substitution for the given alphabet in the cipher text based on the key
        Map<Character, Character> dict2 = new HashMap<>();
        for (int i = 0; i < allLetters.length(); i++) {
            dict2.put(allLetters.charAt(i),
                    allLetters.charAt((i - key + allLetters.length()) % allLetters.length()));
        }
 
        StringBuilder decryptedText = new StringBuilder();
 
        // loop to recover plain text
        for (char c : cipherText.toString().toCharArray()) {
            if (allLetters.indexOf(c) != -1) {
                decryptedText.append(dict2.get(c));
            } else {
                decryptedText.append(c);
            }
        }
 
        System.out.println("Recovered plain text: " + decryptedText);
        return cipherText.toString();
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        String usn = request.getParameter("usn");
        String name = request.getParameter("name");
        String address = request.getParameter("adress");
        String contact = request.getParameter("contact");
        student student = new student();
        student.setUsn(encrypt(usn));
        student.setName(encrypt(name));
        student.setAddr(encrypt(address));
        student.setMob(encrypt(contact));
        
        try {
            studentDao.registerStudent(student);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("studentDetails.jsp");
    }
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException,
                                                 ServletException {
doPost(request, response);
}
}
