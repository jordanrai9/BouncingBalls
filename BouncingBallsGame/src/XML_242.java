
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: XML_242.java
 Short description: stores the rankings and times of game
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
public class XML_242
{

    //encoder and decoder
    XMLEncoder xe;
    XMLDecoder de;

    public XML_242()
    {

    }
//==========================================================================

    //reads file
    public void openReaderXML(String filename)
    {
        try
        {
            de = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    //writes file
    public void openWriterXML(String filename)
    {
        try
        {
            xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    //writes object
    public void writeObject(Object o)
    {
        try
        {
            xe.writeObject(o);
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================

    //reads object
    public Object ReadObject()
    {
        Object o = new Object();
        try
        {
            o = de.readObject();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
        return o;
    }
//==========================================================================
   //close reader
    public void closeReaderXML()
    {
        try
        {
            de.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================
    //close writer
    public void closeWriterXML()
    {
        try
        {
            xe.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
}

