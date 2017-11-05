package com.hbo.got;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.imageio.ImageIO;

import com.hbo.got.dao.IMeaningDAO;
import com.hbo.got.dao.IVocabularyDAO;
import com.hbo.got.dao.MeaningDAOImpl;
import com.hbo.got.dao.VocabularyDAOImpl;
import com.hbo.got.entity.Meaning;
import com.hbo.got.entity.Vocabulary;
import com.hbo.got.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		BufferedReader br = null;
        IVocabularyDAO vocaDAO = new VocabularyDAOImpl();
        IMeaningDAO meaningDAO = new MeaningDAOImpl();

        try {

            br = new BufferedReader(new InputStreamReader(System.in));
            String currentKey = "";
            while (true) {
            		System.out.print("1.Quit ");
            		System.out.print("2.Add ");
            	    System.out.print("3.Import ");
                System.out.print("4.Count all ");
                System.out.print("5.List all ");
                System.out.println("6.Search");
                String input = br.readLine();
                if ("1".equals(input)) {
                    System.out.println("Goodbye and Happy Learning!");
                    System.exit(0);
                }
               else if("2".equals(input)) {
                	System.out.println("-----------------------------------------");
	                	Vocabulary voca = new Vocabulary();
	                	Meaning meaning = new Meaning();
	            		System.out.print("Enter voca: ");
	            		input = br.readLine();
	            		voca.setVoca(input);
	            		Long vocaId = vocaDAO.save(voca);
	            		if(vocaId != null) {
	            			System.out.println("Saved word "+voca.getVoca()+" success");
	            		}
	            		else {
	            			System.out.println("Saved word "+voca.getVoca()+" failed");
	            		}
	            		
	            		// meaning
	            		System.out.print("Enter En Mean: ");
	            		input = br.readLine();
	            		meaning.setEnMean(input);
	            		meaning.setVocabulary(voca);
	            		Long meaningId = meaningDAO.save(meaning);
	            		
	            		if(meaningId != null) {
	            			System.out.println("Saved meaning of word "+voca.getVoca()+" success.");
	            		}
	            		else {
	            			System.out.println("Saved meaning of word "+voca.getVoca()+" failed");
	            		}
	            		
	            		System.out.println("-----------------------------------------");
                }
                // search 
               else if("5".equals(input)) {
               	System.out.println("-----------------------------------------");
               		List<Vocabulary> list = vocaDAO.findAll();
               		if(list != null) {
               			System.out.println("There are "+list.size()+" words.");
               			for(int i  = 0; i< list.size(); i++) {
               				Vocabulary voca = list.get(i);
               				System.out.println("Word "+i+ " : "+voca.getVoca());
               			}
               		}
               		System.out.println("-----------------------------------------");
               }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
