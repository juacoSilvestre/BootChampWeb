package com.organization.bootchampweb.service;

import com.organization.bootchampweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Repository
public class UserMessage {

    public String showUser(User user){
        String str = "";
/*       try {

            for (UserItem item :user.getUserItems()){
            str+="Name: "+item.getItems().+"/n"+"Price: "+item.+"/n"+
                    "Calification: "+item.getGames().getCalification()+"/n"+"Genre: "+item.getGames().getGenre()+"/n"+
                    "Creation date: "+item.getGames().getCreationDate()+"/n"+"Edition Date: "+item.getGames().getEditionDate()+"/n"+
                    "Deletion date: "+item.getGames().getDeletionDate()+"/n"+"Mobile description: "+item.getGames().getDescription().getMobileDescription()+"/n"+
                    "Web description: "+item.getGames().getDescription().getWebDescription()+"/n"+"Id: "+item.getGames().getId()+"/n";
        }}catch (StackOverflowError e){return "The GamesList its empty";}
        finally {
            return "Name: "+ user.getName()+"\n"+"Username: "+user.getUserName()+"\n"+
                    "Email: " + user.getEmail()+"\n"+"Password: "+user.getPassword()+"\n"+
                    "Birthdate: "+ user.getBirthdate()+"\n"+"Id: "+user.getId()+"\n"
                    +"Creation date: "+ user.getCreationDate()+"/n"+"Edition date: "+user.getEditionDate()+"\n"
                    +"Deletion date: "+ user.getDeletionDate()+"\n"+"Games: \n"+str;
        }

}*/
return "nooooo!!!";}
}
