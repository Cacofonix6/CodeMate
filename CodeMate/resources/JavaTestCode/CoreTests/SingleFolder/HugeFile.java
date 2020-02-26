import java.util.*;
/**
 * This is a Music Database program that stores song information  
 * and lets the user add songs to the database and make playlists
 * @Robert Toy
 * @3/5/2015
 * Sorry about the length
 * I used alot of repeated code, probably should have made more methods
 */
public class HugeFile{
    private String newArtist,newSong,addSong;
    private float newSize;
    private int newDurationMinutes,newDurationSeconds;   
    
    public static void main(String[] args){
        HugeFile intFace = new Interface();
        intFace.run();
    }
    
    private void PlaylistMenu() //Method that lists playlist options
    {
        System.out.println("(1) View songs in playlist");
        System.out.println("(2) Add song to playlist");
        System.out.println("(3) Delete song from playlist");
        System.out.println("(0) Back to main menu");       
    }    
        
    private void run() //Interface
    {
        Scanner console = new Scanner(System.in);
        
        boolean x = false;
        boolean y = false;
        String choose = "";
        int choice = 0;
        SongDatabase s = new SongDatabase();
        Playlist p1 = new Playlist();
        Playlist p2 = new Playlist();
        
        while (x != true){     //returns user to main menu when x = false
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Song Database");
            System.out.println("(1) Songs");
            System.out.println("(2) Playlists");
            System.out.println("(0) Exit");
            y = false;
            while (y != true){     //used same while loop for every menu choice
                System.out.println("----------------------------------------------------------------------");              
                choose = console.next();
                if(choose.equals("0") || choose.equals("1") || choose.equals("2")){
                    choice = Integer.parseInt(choose);
                    y = true;
                }                           
                else{
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Invalid input, must enter a number from 0 to 2");
                    y = false;
                }
                            
            }         
            if(choice == 0){
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Goodbye :)");   //exit message
                System.exit(0);
            }
            else if(choice == 1){
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Songs");
                System.out.println("(1) Add new Song");
                System.out.println("(2) View all songs");
                System.out.println("(3) View songs under duration x (minutes)");
                System.out.println("(4) Delete a song");
                System.out.println("(0) Back to main menu");
                y = false;
                while (y != true){
                    System.out.println("----------------------------------------------------------------------");
                    choose = console.next();
                    if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4")){
                        choice = Integer.parseInt(choose);
                        y = true;

                    }                           
                    else{
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Invalid input, must enter a number from 0 to 4");
                        y = false;
                    }
                           
                }
                //this takes input for song names and stores them in string or float or int depending on type of data
                if(choice == 1){  
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Enter song name:");
                    newSong = console.next();
                    System.out.println("Enter song artist:");
                    newArtist = console.next();
                    System.out.println("Enter song duration minutes:");
                    y = false;
                    while (y != true){
                        try{
                            newDurationMinutes = console.nextInt();
                            y = true;
                        }
                        catch(InputMismatchException exception){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a number");
                            console.next();
                            y = false;
                        }
                    }    
                    
                    System.out.println("Enter song duration seconds:");
                    y = false;
                    while (y != true){
                        try{
                            newDurationSeconds = console.nextInt();
                            y = true;
                        }
                        catch(InputMismatchException exception){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a number");
                            console.next();
                            y = false;
                        }
                    }   
                    System.out.println("Enter song file size in mb:");
                    y =false;
                    while (y != true){
                        try{
                            newSize = console.nextFloat();
                            newSize = newSize / 1;
                            y = true;
                        }
                        catch(InputMismatchException exception){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a number");
                            console.next();
                            y = false;
                        }
                    }   
                    
                    if(s.SongName(1).equals(newSong) && s.SongArtist(1).equals(newArtist)){
                        if(Integer.parseInt(s.SongDurationSeconds(1)) == newDurationSeconds && s.SongDurationMinutes(1) == newDurationMinutes && s.SongSize(1) == newSize){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Song already exists in database");
                            x = false;
                        }
                    }
                    else if(s.SongName(2).equals(newSong) && s.SongArtist(2).equals(newArtist)){
                        if(Integer.parseInt(s.SongDurationSeconds(2)) == newDurationSeconds && s.SongDurationMinutes(2) == newDurationMinutes && s.SongSize(2) == newSize){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Song already exists in database");
                            x = false;
                        }
                    }
                    else if(s.SongName(3).equals(newSong) && s.SongArtist(3).equals(newArtist)){
                        if(Integer.parseInt(s.SongDurationSeconds(3)) == newDurationSeconds && s.SongDurationMinutes(3) == newDurationMinutes && s.SongSize(3) == newSize){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Song already exists in database");
                            x = false;
                        }
                    }
                    else if(s.SongName(4).equals(newSong) && s.SongArtist(4).equals(newArtist)){
                        if(Integer.parseInt(s.SongDurationSeconds(4)) == newDurationSeconds && s.SongDurationMinutes(4) == newDurationMinutes && s.SongSize(4) == newSize){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Song already exists in database");
                            x = false;
                        }
                    }
                    else{
                        
                        //this stores the data in the Song class and checks for existing data   
                        
                        if(s.SongName(1) == ""){                   
                            s.addSong(1,newSong,newArtist);
                            s.addData(1,newDurationSeconds,newDurationMinutes,newSize);
                            s.SetSongExist(1, true);
                        }
                        else if(s.SongName(2) == "" && s.SongName(1) != ""){
                            s.addSong(2,newSong,newArtist);
                            s.addData(2,newDurationSeconds,newDurationMinutes,newSize);
                            s.SetSongExist(2, true);
                        }
                         else if(s.SongName(3) == "" && s.SongName(1) != "" && s.SongName(2) != ""){
                            s.addSong(3,newSong,newArtist);
                            s.addData(3,newDurationSeconds,newDurationMinutes,newSize);
                            s.SetSongExist(3, true);
                        }
                         else if(s.SongName(4) == "" && s.SongName(1) != "" && s.SongName(2) != "" && s.SongName(3) != ""){
                            s.addSong(4,newSong,newArtist);
                            s.addData(4,newDurationSeconds,newDurationMinutes,newSize);
                            s.SetSongExist(4, true);
                        }
                         else if(s.SongName(4) != "" && s.SongName(1) != "" && s.SongName(2) != "" && s.SongName(3) != ""){ // if all song files have data ask if user wants to override
                             System.out.println("----------------------------------------------------------------------");
                            System.out.println("Song Database is full would you like to override a song? ( Yes (1)  / No (2) )");
                            y = false;
                            while (y != true){
                                System.out.println("----------------------------------------------------------------------");
                                choose = console.next();
                                if(choose.equals("1") || choose.equals("2")){
                                    choice = Integer.parseInt(choose);
                                    y = true;
                                }                           
                                else{
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Invalid input, must enter either a 1 or 2");
                                    y = false;
                                }
                                
                            }
                            
                            if(choice == 1){  // this lets user select which song to override           
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Which song do you want to replace? (1 - 4)");
                                System.out.println("(1) Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                                System.out.println("(2) Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                                System.out.println("(3) Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                                System.out.println("(4) Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                                System.out.println("(0) Back to main menu");  
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4") || choose.equals("0")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter a number from 0 to 4");
                                        y = false;
                                    }
                                
                                }
                                
                                if(choice == 1){ //messages to let user know the song was replaced
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println(" ~Replaced Song 1 with new song~");
                                    s.addSong(1,newSong,newArtist);
                                    s.addData(1,newDurationSeconds,newDurationMinutes,newSize);
                                    x = false;
                                }
                                else if(choice == 2){
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println(" ~Replaced Song 2 with new song~");
                                    s.addSong(2,newSong,newArtist);
                                    s.addData(2,newDurationSeconds,newDurationMinutes,newSize);
                                    x = false;
                                }
                                else if(choice == 3){
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println(" ~Replaced Song 3 with new song~");
                                    s.addSong(3,newSong,newArtist);
                                    s.addData(3,newDurationSeconds,newDurationMinutes,newSize);
                                    x = false;
                                }
                                else if(choice == 4){
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println(" ~Replaced Song 4 with new song~");
                                    s.addSong(4,newSong,newArtist);
                                    s.addData(4,newDurationSeconds,newDurationMinutes,newSize);
                                    x = false;
                                }
                                else if(choice == 0){
                                    x = false;
                                }
                                
                            }
                            else if(choice != 1){
                                x = false;
                            }
                            
                            x = false;   
                        } 
                    
                        x = false;
                    }
                }
            
                   
               
                else if(choice == 2){ //prints all songs
                    if(s.GetSongExist(1) != true && s.GetSongExist(2) != true && s.GetSongExist(3) != true && s.GetSongExist(4) != true){
                        System.out.println("No songs have been added yet");
                        x = false;
                    }
                    else{
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("All songs");
                        if(s.GetSongExist(1) == true){System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));}
                        if(s.GetSongExist(2) == true){System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));}
                        if(s.GetSongExist(3) == true){System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));}
                        if(s.GetSongExist(4) == true){System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));}
                    }
                }
                
                //this converts minutes to seconds for next check
                else if(choice == 3){ 
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("View songs under how many minutes long?");
                    y = false;
                    while (y != true){ 
                        
                        try{
                            choice = console.nextInt();
                            if(choice >= 1){
                                choice = (choice*60);
                                y = true;
                            }
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a positive number");
                                y = false;
                            }
                        }     
                        catch(InputMismatchException exception){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a positive number");
                            console.next();
                            y = false;
                        } 
                    }
                    
                    // this next bulk of code checks duration of songs and lists the songs less than or equal the time entered
                    
                    if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(3) && choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(3) != 0 && s.SongSecondsTotal(4) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }

                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(3) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                    }
                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(4) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(4) && choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(4) != 0 && s.SongSecondsTotal(3) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(4) && choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(4) != 0 && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(3) != 0){
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(2) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(2) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));           
                    }
                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(3) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                    }
                    else if(choice >= s.SongSecondsTotal(1) && choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(1) != 0 && s.SongSecondsTotal(4) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(3) != 0){
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                    }
                    else if(choice >= s.SongSecondsTotal(2) && choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(2) != 0 && s.SongSecondsTotal(4) != 0){
                         System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                         System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(3) && choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(3) != 0 && s.SongSecondsTotal(4) != 0){
                       System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                       System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                    else if(choice >= s.SongSecondsTotal(1) && s.SongSecondsTotal(1) != 0){
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                    }
                    else if(choice >= s.SongSecondsTotal(2) && s.SongSecondsTotal(2) != 0){
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                    }
                    else if(choice >= s.SongSecondsTotal(3) && s.SongSecondsTotal(3) != 0){
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                    }
                    else if(choice >= s.SongSecondsTotal(4) && s.SongSecondsTotal(4) != 0){
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                    }
                }
                
                else if(choice == 4){ //this lets the user select which song to delete
                    if(s.GetSongExist(1) || s.GetSongExist(2) || s.GetSongExist(3) || s.GetSongExist(4))
                    {
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Which song would you like to delete?");
                        if(s.GetSongExist(1)){;System.out.println("(1) Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));}
                        if(s.GetSongExist(2)){System.out.println("(2) Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));}
                        if(s.GetSongExist(3)){System.out.println("(3) Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));}
                        if(s.GetSongExist(4)){System.out.println("(4) Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4)); }              
                        System.out.println("(0) Back to main menu");
                    
                        y = false;
                        while (y != true){ 
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 4");
                                y = false;
                            }
                         
                        }
                        //this ovverides the song with blank data
                        if(choice == 1){
                            if(s.GetSongExist(1) != true){System.out.println("No song file to delete"); 
                                x = false;
                            } 
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println(" ~Song 1 Deleted~");
                                s.addSong(1,"","");
                                s.addData(1,0,0,0);
                                s.SetSongExist(1,false);
                                if(s.SongName(1) == p1.PlaylistSong(1) && s.SongArtist(1) == p1.PlaylistArtist(1)){
                                    p1.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(1) == p1.PlaylistSong(2) && s.SongArtist(1) == p1.PlaylistArtist(2)){
                                    p1.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(1) == p1.PlaylistSong(3) && s.SongArtist(1) == p1.PlaylistArtist(3)){
                                    p1.addToPlaylist(3,"","");
                                }
                                else if(s.SongName(1) == p2.PlaylistSong(1) && s.SongArtist(1) == p2.PlaylistArtist(1)){
                                    p2.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(1) == p2.PlaylistSong(2) && s.SongArtist(1) == p2.PlaylistArtist(2)){
                                    p2.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(1) == p2.PlaylistSong(3) && s.SongArtist(1) == p2.PlaylistArtist(3)){
                                    p2.addToPlaylist(3,"","");
                                }
                            }
                        }
                        else if(choice == 2){
                            if(s.GetSongExist(2) != true){System.out.println("No song file to delete"); 
                                x = false;
                            } 
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println(" ~Song 2 Deleted~");
                                s.addSong(2,"","");
                                s.addData(2,0,0,0);
                                s.SetSongExist(2,false); 
                                if(s.SongName(2) == p1.PlaylistSong(1) && s.SongArtist(2) == p1.PlaylistArtist(1)){
                                    p1.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(2) == p1.PlaylistSong(2) && s.SongArtist(2) == p1.PlaylistArtist(2)){
                                    p1.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(2) == p1.PlaylistSong(3) && s.SongArtist(2) == p1.PlaylistArtist(3)){
                                    p1.addToPlaylist(3,"","");
                                }
                                else if(s.SongName(2) == p2.PlaylistSong(1) && s.SongArtist(2) == p2.PlaylistArtist(1)){
                                    p2.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(2) == p2.PlaylistSong(2) && s.SongArtist(2) == p2.PlaylistArtist(2)){
                                    p2.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(2) == p2.PlaylistSong(3) && s.SongArtist(2) == p2.PlaylistArtist(3)){
                                    p2.addToPlaylist(3,"","");
                                }
                            }
                        }
                        else if(choice == 3){
                            if(s.GetSongExist(3) != true){System.out.println("No song file to delete");
                                x = false;
                            } 
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println(" ~Song 3 Deleted~");
                                s.addSong(3,"","");
                                s.addData(3,0,0,0);
                                s.SetSongExist(3,false); 
                                if(s.SongName(3) == p1.PlaylistSong(1) && s.SongArtist(3) == p1.PlaylistArtist(1)){
                                    p1.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(3) == p1.PlaylistSong(2) && s.SongArtist(3) == p1.PlaylistArtist(2)){
                                    p1.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(3) == p1.PlaylistSong(3) && s.SongArtist(3) == p1.PlaylistArtist(3)){
                                    p1.addToPlaylist(3,"","");
                                }
                                else if(s.SongName(3) == p2.PlaylistSong(1) && s.SongArtist(3) == p2.PlaylistArtist(1)){
                                    p2.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(3) == p2.PlaylistSong(2) && s.SongArtist(3) == p2.PlaylistArtist(2)){
                                    p2.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(3) == p2.PlaylistSong(3) && s.SongArtist(3) == p2.PlaylistArtist(3)){
                                    p2.addToPlaylist(3,"","");
                                }
                            }
                        }
                        else if(choice == 4){
                            if(s.GetSongExist(4) != true){System.out.println("No song file to delete"); 
                                x = false;
                            }
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println(" ~Song 4 Deleted~");
                                s.addSong(4,"","");
                                s.addData(4,0,0,0);
                                s.SetSongExist(4,false); 
                                if(s.SongName(4) == p1.PlaylistSong(1) && s.SongArtist(4) == p1.PlaylistArtist(1)){
                                    p1.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(4) == p1.PlaylistSong(2) && s.SongArtist(4) == p1.PlaylistArtist(2)){
                                    p1.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(4) == p1.PlaylistSong(3) && s.SongArtist(4) == p1.PlaylistArtist(3)){
                                    p1.addToPlaylist(3,"","");
                                }
                                else if(s.SongName(4) == p2.PlaylistSong(1) && s.SongArtist(4) == p2.PlaylistArtist(1)){
                                    p2.addToPlaylist(1,"","");
                                }
                                else if(s.SongName(4) == p2.PlaylistSong(2) && s.SongArtist(4) == p2.PlaylistArtist(2)){
                                    p2.addToPlaylist(2,"","");
                                }
                                else if(s.SongName(4) == p2.PlaylistSong(3) && s.SongArtist(4) == p2.PlaylistArtist(3)){
                                    p2.addToPlaylist(3,"","");
                                }
                            }
                        }
                        else if(choice == 0){
                            x = false;
                        }
                    }
                    else{
                        System.out.println("No songs to delete");
                        x = false;
                    }
                    x = false;
                }
                else if(choice == 0){
                    x = false;
                }
                
            }
                          

            
            else if(choice == 2){  
                // this menu only shows playlist 1 or 2 if they have been created
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Playlists");
                System.out.println("(1) Create new Playlist");
                if(p1.getExist() == true){System.out.println("(2) Playlist 1");}
                if(p2.getExist() == true){System.out.println("(3) Playlist 2");}
                System.out.println("(4) Delete a playlist");
                System.out.println("(0) Back to main menu");
                y = false;
                while (y != true){  
                    System.out.println("----------------------------------------------------------------------");
                    choose = console.next();
                    if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4")){
                        choice = Integer.parseInt(choose);
                        y = true;                  
                    }                           
                    else{
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Invalid input, must enter a number from 0 to 4");
                        y = false;
                    }
                            
                }
                //this checks if any playlists exist before creating one, if both exist the user will need to delete one via delete playlist function
                if(choice == 1){
                    if(p1.getExist() == true){
                        if(p2.getExist() == true){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Two playlists already exist, delete one first, or add to an existing playlist");
                        }
                        else if(p2.getExist() == false){
                            p2.setExist(true);
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Playlist 2 created");
                        }
                    }
                    else if(p1.getExist() == false){
                        p1.setExist(true);
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 1 created");
                    }
                }
                else if(choice == 2){
                    PlaylistMenu();
                    y = false;
                    while (y != true){     
                        System.out.println("----------------------------------------------------------------------");
                        choose = console.next();
                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                            choice = Integer.parseInt(choose);
                            y = true;

                        }                           
                        else{
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a number from 0 to 3");
                            y = false;
                        }
                            
                    }

                    if(choice == 1){ //lists all songs in playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 1:");
                        System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                        System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                        System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                    }
                    else if(choice == 2){ //lists songs in database and lets user choose one to be added to playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Which song do you want to add to Playlist (0 - 4)");
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                        System.out.println("(0) Back to main menu");
                        y = false;
                        while (y != true){
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 4");
                                y = false;
                            }
                            
                        }
                        
                        //this adds the song to the playlist if there is room
                        if(choice == 1){
                            
                            if(p1.PlaylistSong(1) == ""){                       
                                p1.addToPlaylist(1,s.SongName(1),s.SongArtist(1)); 
                                p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p1.PlaylistSong(2) == "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(2,s.SongName(1),s.SongArtist(1)); 
                                p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p1.PlaylistSong(3) == "" && p1.PlaylistSong(2) != "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(3,s.SongName(1),s.SongArtist(1)); 
                                p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p1.PlaylistSong(3) != "" && p1.PlaylistSong(1) != "" && p1.PlaylistSong(2) != ""){
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                //this lets the user replace a song
                                if(choice == 1){              
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){          
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //messages to let user know the song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p1.addToPlaylist(1,s.SongName(1),s.SongArtist(1)); 
                                        p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p1.addToPlaylist(2,s.SongName(1),s.SongArtist(1)); 
                                        p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p1.addToPlaylist(3,s.SongName(1),s.SongArtist(1)); 
                                        p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                       
                           
                            }                        
                        }
                        else if(choice == 2){ //same add to playlist method as earlier but for song 2 (i should have made this a method somehow)
                            if(p1.PlaylistSong(1) == ""){                       
                                p1.addToPlaylist(1,s.SongName(2),s.SongArtist(2)); 
                                p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p1.PlaylistSong(2) == "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(2,s.SongName(2),s.SongArtist(2)); 
                                p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p1.PlaylistSong(3) == "" && p1.PlaylistSong(2) != "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(3,s.SongName(2),s.SongArtist(2)); 
                                p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p1.PlaylistSong(3) != "" && p1.PlaylistSong(1) != "" && p1.PlaylistSong(2) != ""){  //checks if songs exist, if playlist is full, ask if user wants to override
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                        
                                if(choice == 1){      //replace song menu
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){  
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //lets user know the song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p1.addToPlaylist(1,s.SongName(2),s.SongArtist(2)); 
                                        p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p1.addToPlaylist(2,s.SongName(2),s.SongArtist(2)); 
                                        p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p1.addToPlaylist(3,s.SongName(2),s.SongArtist(2)); 
                                        p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 3){ //same code as earlier for adding the 3rd song to playlist
                            if(p1.PlaylistSong(1) == ""){                       
                                p1.addToPlaylist(1,s.SongName(3),s.SongArtist(3)); 
                                p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p1.PlaylistSong(2) == "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(2,s.SongName(3),s.SongArtist(3)); 
                                p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p1.PlaylistSong(3) == "" && p1.PlaylistSong(2) != "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(3,s.SongName(3),s.SongArtist(3)); 
                                p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p1.PlaylistSong(3) != "" && p1.PlaylistSong(1) != "" && p1.PlaylistSong(2) != ""){
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");  //override choice
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                //replace song in playlist menu
                                if(choice == 1){         
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){     
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //messages to let user know song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p1.addToPlaylist(1,s.SongName(3),s.SongArtist(3)); 
                                        p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p1.addToPlaylist(2,s.SongName(3),s.SongArtist(3)); 
                                        p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p1.addToPlaylist(3,s.SongName(3),s.SongArtist(3)); 
                                        p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }  
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 4){ //same code for adding 4th song
                            if(p1.PlaylistSong(1) == ""){                       
                                p1.addToPlaylist(1,s.SongName(4),s.SongArtist(4)); 
                                p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p1.PlaylistSong(2) == "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(2,s.SongName(4),s.SongArtist(4)); 
                                p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p1.PlaylistSong(3) == "" && p1.PlaylistSong(2) != "" && p1.PlaylistSong(1) != ""){
                                p1.addToPlaylist(3,s.SongName(4),s.SongArtist(4)); 
                                p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p1.PlaylistSong(3) != "" && p1.PlaylistSong(1) != "" && p1.PlaylistSong(2) != ""){
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )"); //ovveride song choice
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                // which song to replace?
                                if(choice == 1){       
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){        
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //success message
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p1.addToPlaylist(1,s.SongName(4),s.SongArtist(4)); 
                                        p1.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p1.addToPlaylist(2,s.SongName(4),s.SongArtist(4)); 
                                        p1.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p1.addToPlaylist(3,s.SongName(4),s.SongArtist(4)); 
                                        p1.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 0){
                            x = false;
                        }
                    }                  
                    else if(choice == 3){ //delete song from playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Which song do you want to delete? (1 - 3)");
                        System.out.println("(1) Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                        System.out.println("(2) Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                        System.out.println("(3) Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                        System.out.println("(0) Back to main menu");
                        y = false;
                        while (y != true){
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                           else{
                               System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 3");
                                y = false;
                           }
                        }
                        //shows user if song was delete from playlist
                        if(choice == 1){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 1 Deleted~");
                            p1.addToPlaylist(1,"","");
                            p1.addPlaylistData(1,0,0,0);
                        }
                        else if(choice == 2){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 2 Deleted~");
                            p1.addToPlaylist(2,"","");
                            p1.addPlaylistData(2,0,0,0);
                        }
                        else if(choice == 3){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 3 Deleted~");
                            p1.addToPlaylist(3,"","");
                            p1.addPlaylistData(3,0,0,0);
                        }
                    
                    }
                    else if(choice == 0){
                        x = false;
                    }
                    
                }
                
                
                
                
                
                
                
                else if(choice == 3){ //same code as above but for playlist 2...
                    PlaylistMenu();
                    y = false;
                    while (y != true){     
                        System.out.println("----------------------------------------------------------------------");
                        choose = console.next();
                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                            choice = Integer.parseInt(choose);
                            y = true;

                        }                           
                        else{
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println("Invalid input, must enter a number from 0 to 3");
                            y = false;
                        }
                            
                    }

                    if(choice == 1){ //lists all songs in playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 2:");
                        System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                        System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                        System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                    }
                    else if(choice == 2){ //lists songs in database and lets user choose one to be added to playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Which song do you want to add to Playlist (0 - 4)");
                        System.out.println("1. Song Name: " + s.SongName(1) + " | " + "Song Artist: " + s.SongArtist(1) + " | "+ "Song Duration: " + s.SongDurationMinutes(1) + ":" + s.SongDurationSeconds(1) + " | "+ "Song Size: " + s.SongSize(1));
                        System.out.println("2. Song Name: " + s.SongName(2) + " | " + "Song Artist: " + s.SongArtist(2) + " | "+ "Song Duration: " + s.SongDurationMinutes(2) + ":" + s.SongDurationSeconds(2) + " | "+ "Song Size: " + s.SongSize(2));
                        System.out.println("3. Song Name: " + s.SongName(3) + " | " + "Song Artist: " + s.SongArtist(3) + " | "+ "Song Duration: " + s.SongDurationMinutes(3) + ":" + s.SongDurationSeconds(3) + " | "+ "Song Size: " + s.SongSize(3));
                        System.out.println("4. Song Name: " + s.SongName(4) + " | " + "Song Artist: " + s.SongArtist(4) + " | "+ "Song Duration: " + s.SongDurationMinutes(4) + ":" + s.SongDurationSeconds(4) + " | "+ "Song Size: " + s.SongSize(4));
                        System.out.println("(0) Back to main menu");
                        y = false;
                        while (y != true){
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3") || choose.equals("4")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 4");
                                y = false;
                            }
                            
                        }
                        
                        //this adds the song to the playlist if there is room
                        if(choice == 1){
                            
                            if(p2.PlaylistSong(1) == ""){                       
                                p2.addToPlaylist(1,s.SongName(1),s.SongArtist(1)); 
                                p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p2.PlaylistSong(2) == "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(2,s.SongName(1),s.SongArtist(1)); 
                                p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p2.PlaylistSong(3) == "" && p2.PlaylistSong(2) != "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(3,s.SongName(1),s.SongArtist(1)); 
                                p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                            }
                            else if(p2.PlaylistSong(3) != "" && p2.PlaylistSong(1) != "" && p2.PlaylistSong(2) != ""){
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                //this lets the user replace a song
                                if(choice == 1){              
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){          
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //messages to let user know the song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p2.addToPlaylist(1,s.SongName(1),s.SongArtist(1)); 
                                        p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p2.addToPlaylist(2,s.SongName(1),s.SongArtist(1)); 
                                        p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p2.addToPlaylist(3,s.SongName(1),s.SongArtist(1)); 
                                        p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(1)),s.SongDurationMinutes(1),s.SongSize(1));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                       
                           
                            }                        
                        }
                        else if(choice == 2){ //same add to playlist method as earlier but for song 2 (i should have made this a method somehow)
                            if(p2.PlaylistSong(1) == ""){                       
                                p2.addToPlaylist(1,s.SongName(2),s.SongArtist(2)); 
                                p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p2.PlaylistSong(2) == "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(2,s.SongName(2),s.SongArtist(2)); 
                                p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p2.PlaylistSong(3) == "" && p2.PlaylistSong(2) != "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(3,s.SongName(2),s.SongArtist(2)); 
                                p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                            }
                            else if(p2.PlaylistSong(3) != "" && p2.PlaylistSong(1) != "" && p2.PlaylistSong(2) != ""){  //checks if songs exist, if playlist is full, ask if user wants to override
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                        
                                if(choice == 1){      //replace song menu
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){  
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //lets user know the song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p2.addToPlaylist(1,s.SongName(2),s.SongArtist(2)); 
                                        p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p2.addToPlaylist(2,s.SongName(2),s.SongArtist(2)); 
                                        p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p2.addToPlaylist(3,s.SongName(2),s.SongArtist(2)); 
                                        p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(2)),s.SongDurationMinutes(2),s.SongSize(2));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 3){ //same code as earlier for adding the 3rd song to playlist
                            if(p2.PlaylistSong(1) == ""){                       
                                p2.addToPlaylist(1,s.SongName(3),s.SongArtist(3)); 
                                p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p2.PlaylistSong(2) == "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(2,s.SongName(3),s.SongArtist(3)); 
                                p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p2.PlaylistSong(3) == "" && p2.PlaylistSong(2) != "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(3,s.SongName(3),s.SongArtist(3)); 
                                p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                            }
                            else if(p2.PlaylistSong(3) != "" && p2.PlaylistSong(1) != "" && p2.PlaylistSong(2) != ""){
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )");  //override choice
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                //replace song in playlist menu
                                if(choice == 1){         
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){     
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //messages to let user know song was replaced
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p2.addToPlaylist(1,s.SongName(3),s.SongArtist(3)); 
                                        p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p2.addToPlaylist(2,s.SongName(3),s.SongArtist(3)); 
                                        p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p2.addToPlaylist(3,s.SongName(3),s.SongArtist(3)); 
                                        p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(3)),s.SongDurationMinutes(3),s.SongSize(3));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }  
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 4){ //same code for adding 4th song
                            if(p2.PlaylistSong(1) == ""){                       
                                p2.addToPlaylist(1,s.SongName(4),s.SongArtist(4)); 
                                p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p2.PlaylistSong(2) == "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(2,s.SongName(4),s.SongArtist(4)); 
                                p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p2.PlaylistSong(3) == "" && p2.PlaylistSong(2) != "" && p2.PlaylistSong(1) != ""){
                                p2.addToPlaylist(3,s.SongName(4),s.SongArtist(4)); 
                                p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                            }
                            else if(p2.PlaylistSong(3) != "" && p2.PlaylistSong(1) != "" && p2.PlaylistSong(2) != ""){
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Playlist is full would you like to override a song? ( Yes (1)  / No (2) )"); //ovveride song choice
                                y = false;
                                while (y != true){
                                    System.out.println("----------------------------------------------------------------------");
                                    choose = console.next();
                                    if(choose.equals("1") || choose.equals("2")){
                                        choice = Integer.parseInt(choose);
                                        y = true;
                                    }                           
                                    else{
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println("Invalid input, must enter either a 1 or 2");
                                        y = false;
                                    }
                            
                                }
                                // which song to replace?
                                if(choice == 1){       
                                    System.out.println("----------------------------------------------------------------------");
                                    System.out.println("Which song do you want to replace? (1 - 3)");
                                    System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                                    System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                                    System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                                    System.out.println("(0) Back to main menu");
                                    y = false;
                                    while (y != true){        
                                        System.out.println("----------------------------------------------------------------------");
                                        choose = console.next();
                                        if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                            choice = Integer.parseInt(choose);
                                            y = true;
                                        }                           
                                        else{
                                            System.out.println("----------------------------------------------------------------------");
                                            System.out.println("Invalid input, must enter a number from 0 to 3");
                                            y = false;
                                        }
                            
                                    }
                                    //success message
                                    if(choice == 1){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 1 with new song~");
                                        p2.addToPlaylist(1,s.SongName(4),s.SongArtist(4)); 
                                        p2.addPlaylistData(1,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }
                                    else if(choice == 2){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 2 with new song~");
                                        p2.addToPlaylist(2,s.SongName(4),s.SongArtist(4)); 
                                        p2.addPlaylistData(2,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }
                                    else if(choice == 3){
                                        System.out.println("----------------------------------------------------------------------");
                                        System.out.println(" ~Replaced Song 3 with new song~");
                                        p2.addToPlaylist(3,s.SongName(4),s.SongArtist(4)); 
                                        p2.addPlaylistData(3,Integer.parseInt(s.SongDurationSeconds(4)),s.SongDurationMinutes(4),s.SongSize(4));
                                        x = false;
                                    }

                                    else if(choice == 0){
                                        x = false;
                                    }
                                    
                                }
                                else if(choice != 1){
                                    x = false;
                                }
                            }
                        }
                        else if(choice == 0){
                            x = false;
                        }
                    }                  
                    else if(choice == 3){ //delete song from playlist
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Which song do you want to delete? (1 - 3)");
                        System.out.println("(1) Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                        System.out.println("(2) Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                        System.out.println("(3) Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                        System.out.println("(0) Back to main menu");
                        y = false;
                        while (y != true){
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2") || choose.equals("3")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                           else{
                               System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 3");
                                y = false;
                           }
                        }
                        //shows user if song was delete from playlist
                        if(choice == 1){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 1 Deleted~");
                            p2.addToPlaylist(1,"","");
                            p2.addPlaylistData(1,0,0,0);
                        }
                        else if(choice == 2){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 2 Deleted~");
                            p2.addToPlaylist(2,"","");
                            p2.addPlaylistData(2,0,0,0);
                        }
                        else if(choice == 3){
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Song 3 Deleted~");
                            p2.addToPlaylist(3,"","");
                            p2.addPlaylistData(3,0,0,0);
                        }
                    
                    }
                    else if(choice == 0){
                        x = false;
                    }
 
                }
                else if(choice == 4){
                    if(p1.getExist() == true && p2.getExist() == true){
                        System.out.println("Which playlist do you want to delete?");
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 1:     (1)");
                        System.out.println("1, Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                        System.out.println("2. Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                        System.out.println("3. Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 2:     (2)");
                        System.out.println("1. Song Name: " + p2.PlaylistSong(1) + " | " + "Song Artist: " + p2.PlaylistArtist(1) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(1) + ":" + p2.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p2.PlaylistSongSize(1));
                        System.out.println("2. Song Name: " + p2.PlaylistSong(2) + " | " + "Song Artist: " + p2.PlaylistArtist(2) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(2) + ":" + p2.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p2.PlaylistSongSize(2));
                        System.out.println("3. Song Name: " + p2.PlaylistSong(3) + " | " + "Song Artist: " + p2.PlaylistArtist(3) + " | "+ "Song Duration: " + p2.PlaylistSongMinutes(3) + ":" + p2.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p2.PlaylistSongSize(3));
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("(0) Back to main menu");
                        
                        y = false;
                        while (y != true){ 
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 2");
                                y = false;
                            }
                            
                        }
                        if(choice == 1){
                            p1 = new Playlist();
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Playlist 1 deleted~");
                        }
                        else if(choice == 2){
                            p2 = new Playlist();
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Playlist 2 deleted~");
                        }
                        else if(choice == 0){
                            x = false;
                        }
                    }
                    else if(p1.getExist() == true){
                        System.out.println("Which playlist do you want to delete?");
                        System.out.println("----------------------------------------------------------------------");
                        System.out.println("Playlist 1:     (1)");
                        System.out.println("1, Song Name: " + p1.PlaylistSong(1) + " | " + "Song Artist: " + p1.PlaylistArtist(1) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(1) + ":" + p1.PlaylistSongSeconds(1) + " | "+ "Song Size: " + p1.PlaylistSongSize(1));
                        System.out.println("2. Song Name: " + p1.PlaylistSong(2) + " | " + "Song Artist: " + p1.PlaylistArtist(2) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(2) + ":" + p1.PlaylistSongSeconds(2) + " | "+ "Song Size: " + p1.PlaylistSongSize(2));
                        System.out.println("3. Song Name: " + p1.PlaylistSong(3) + " | " + "Song Artist: " + p1.PlaylistArtist(3) + " | "+ "Song Duration: " + p1.PlaylistSongMinutes(3) + ":" + p1.PlaylistSongSeconds(3) + " | "+ "Song Size: " + p1.PlaylistSongSize(3));
                        y = false;
                        while (y != true){ 
                            System.out.println("----------------------------------------------------------------------");
                            choose = console.next();
                            if(choose.equals("0") || choose.equals("1") || choose.equals("2")){
                                choice = Integer.parseInt(choose);
                                y = true;
                            }                           
                            else{
                                System.out.println("----------------------------------------------------------------------");
                                System.out.println("Invalid input, must enter a number from 0 to 2");
                                y = false;
                            }
                                
                        }
                        if(choice == 1){
                            p1 = new Playlist();
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Playlist 1 deleted~");
                        }
                        else if(choice == 2){
                            p2 = new Playlist();
                            System.out.println("----------------------------------------------------------------------");
                            System.out.println(" ~Playlist 2 deleted~");
                        }
                        else if(choice == 0){
                            x = false;
                        }
                        
                    }
                    else{
                        System.out.println("No playlists exist");
                        x = false;
                    }
                    
                }
                else if(choice == 0){
                    x = false;
                }
            }  //main menu
        } //while
    } //method
} //class



