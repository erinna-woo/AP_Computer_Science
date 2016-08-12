/*==============================================================================
  
name:       ioRAD.java
  
purpose:    An Internet Radio using the PumaJ Framework.
              
history:    Sun Nov 27, 2011 08:46:23 (LBM) created.
  
notes:
                        This program was created by PumaJ
             and is the confidential and proprietary product of PumaJ
        Any unauthorized use, reproduction or transfer is strictly prohibited.
  
                           COPYRIGHT 2011 BY PumaJ
          (Subject to limited distribution and restricted disclosure only).
                             All rights reserved.
  
==============================================================================*/
                                       // package ----------------------------//
   
                                       // imports ----------------------------//
import com.pumaj.PjApplication;
import com.pumaj.PjOval;
import com.pumaj.PjRectangle;
import com.pumaj.PjShape;
import com.pumaj.PjTriangle;
import com.pumaj.PjUtils; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Container;
import java.awt.BorderLayout;
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
 
 
                            // next time try box layout
  
  
                         // PjInternetRadio ====================//
public class PjInternetRadio extends JFrame
{
   
   JLabel currentBackground = null;
   JLabel currentStation = null;
   JLabel stationLabel = null;
   JPanel stationLabelPanel = null;
   
   String[] ButtonGLabels = {"Public Radio/News", "Rock n' Roll", "Seasonal", "Electronic", "Blues", "Country", "Reggae", "Religious", "Cultural",
   "Classical", "Jazz", "Hip Hop", "Rap", "Decades", "Pop", "Alternative"};
   String[] GenreImages = {"resources2/publicradio.jpg", "resources2/rnr.jpg", "resources2/seasonal.jpg", "resources2/electronic.jpg", "resources2/blues.jpg", 
       "resources2/Country.jpg", "resources2/reggae.jpg", "resources2/religious.jpg", "resources2/cultural.jpg",
   "resources2/classical.jpg", "resources2/jazz.jpg", "resources2/hiphop.jpg", "resources2/rap.jpg", "resources2/decades.jpg", "resources2/pop.jpg", "resources2/alternative.jpg"};
   JButton[] numGButtons = new JButton[ButtonGLabels.length];

   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   static final String[] ButtonPRNEWSLabels = {"KQED 88.5", "NPR 90.3", "Comedy 89.7"}; //static - for every class there's only one instance of this every instance of the class shares the same copy
   static final String[] PRNEWSImages = {"resources2/kqed.jpg", "resources2/npr.jpg", "resources2/publicradio.jpg"}; //static - for every class there's only one instance of this every instance of the class shares the same copy
     
   static final String[] ButtonRNRLabels = {"Rock n' Roll 1 89.9 ", "Hard Rock and Heavy Metal 89.3", "Rockabilly 90.5"};
   static final String[] RNRImages = {"resources2/rnr.jpg", "resources2/rnr.jpg", "resources2/rnr.jpg"};
   
   static final String[] ButtonSeasonalLabels = {"Christmas 94.5", "Halloween on Broadway 106.9", "Halloween 89.9"};
   static final String[] SeasonalImages = {"resources2/christmas.jpg", "resources2/halloween.jpg", "resources2/halloween.jpg"};
   
   static final String[] ButtonElectronicLabels = {"Ibiza Global Radio 90.9", "Chillstep 97.9", "Dubstep 110.7"};
   static final String[] ElectronicImages = {"resources2/electronic.jpg", "resources2/electronic.jpg", "resources2/electronic.jpg"};
   
   static final String[] ButtonBluesLabels = {"Blues 103.7", "Chicago Blues 102.5"};
   static final String[] BluesImages = {"resources2/blues.jpg", "resources2/blues.jpg"};
   
   static final String[] ButtonCountryLabels = {"Country 93.5", "Bluegrass 103.9"};
   static final String[] CountryImages = {"resources2/Country.jpg", "resources2/Country.jpg"};
   
   static final String[] ButtonReggaeLabels = {"Reggae 106.7", "Reggae Roots 100.1"};
   static final String[] ReggaeImages = {"resources2/reggae.jpg", "resources2/reggae.jpg"};
   
   static final String[] ButtonReligiousLabels = {"Christian 106.5", "Gregorian Chanting 103.5", "Gospel 99.9", "Guru Nanak Sikh Gurdwara 107.3"};
   static final String[] ReligiousImages = {"resources2/religious.jpg", "resources2/religious.jpg", "resources2/religious.jpg", "resources2/religious.jpg"};
   
   static final String[] ButtonCulturalLabels = {"Latin 94.9", "Asian Pop 96.3", "French 97.3", "KPOP 99.3", "Hawaiian 99.1", "Bollywood Hindi 90.7", "Nigerian 88.9", "Arabic 101.3", "Filipino 107.9", "German 101.5", "Greek 111.3", "Russian 107.1"};
   static final String[] CulturalImages = {"resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg", "resources2/cultural.jpg"};
   
   static final String[] ButtonClassicalLabels = {"Classical Symphony 92.7", "Opera 107.5"};
   static final String[] ClassicalImages = {"resources2/symphony.jpg", "resources2/opera.jpg"};
   
   static final String[] ButtonJazzLabels = {"Swing Jazz 86.3", "Cool Jazz 90.9"};
   static final String[] JazzImages = {"resources2/jazz.jpg", "resources2/jazz.jpg"};
   
   static final String[] ButtonHipHopLabels = {"Hip Hop 100.3", "Hip Hop 100.7", "R&B 97.8"};
   static final String[] HipHopImages = {"resources2/hiphop.jpg", "resources2/hiphop.jpg", "resources2/hiphop.jpg"};
   
   static final String[] ButtonRapLabels = {"Gangsta Rap 87.5", "Underground 105.3"};
   static final String[] RapImages = {"resources2/rap.jpg", "resources2/rap.jpg"};
   
   static final String[] ButtonDecadesLabels = {"50's 110.5", "60's 109.6", "70's 108.7","80's 108.7", "90's 109.3"};
   static final String[] DecadesImages = {"resources2/50s.jpg", "resources2/60s.jpg", "resources2/70s.jpg","resources2/80s.jpg", "resources2/90s.jpg"};
   
   static final String[] ButtonPopLabels = {"Pop 92.0","Broadway 89.5"};
   static final String[] PopImages = {"resources2/pop.jpg","resources2/broadway.jpg"};
   
   static final String[] ButtonAlternativeLabels = {"Alternative Rock 85.7", "Alternative 73.9"};
   static final String[] AlternativeImages = {"resources2/alternative.jpg", "resources2/alternative.jpg"};
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static final /*means promise not to change it */String[] PRNEWSPaths =
      {
         "http://kqed-ice.streamguys.org:80/kqedradio-c2-e1",//kqed
         "http://140.254.23.71:8000", // NPR
         "http://108.61.73.115:8026", //Comedy
      };
       
     static  final String[] RNRPaths = 
      {
         "http://76.73.45.74:8060",//Rock n' Roll classics
     "http://91.121.75.155:8000",//Hard Rock and Heavy metal
     "http://209.9.238.6:6042",//Rockabilly
      };
       
     static  final String[] Seasonal = 
      {
         "http://206.190.136.212:1207/Live", //Christmas
         "http://46.21.151.98:8036", //Halloween 
         "http://174.36.42.110:8270",// Halloween 2
      };
       
     static  final String[] Electronic = 
      {
         "http://37.59.254.27:8024", //Ibiza Global Radio/Electronic
      
     "http://92.114.32.3:9992",//Chillstep
     "http://198.178.123.14:7938",//Dubstep
      };
       
       
      static final String[] Blues = 
      {
         "http://50.7.77.114:8351", //Blues
         "http://65.60.19.42:8040", //Chicago Blues
      };
        
     static  final String[] Country = 
      {
         "http://69.4.234.186:9210", //Country
         "http://192.81.248.91:8069", //Bluegrass
      };
       
     static  final String[] Reggae = 
      {
         "http://188.165.60.91:8300", //Reggae
         "http://184.107.197.154:8002", //Reggae Roots
         
      };
       
      static final String[] Religious = 
      {
            "http://199.180.72.30:8000", //Christian
            "http://206.190.129.220:10700", //Gregorian Chanting
            "http://184.168.89.50:8200", //Gospel
            "http://198.178.123.14:7370", //Guru Nanak Sikh Gurdwara
      };
       
     static  final String[] Cultural = 
      {
            "http://76.72.160.226:9918", //Latin
            "http://50.7.173.162:8093", //Asian Pop?
            "http://5.39.95.24:8000", //French
            "http://50.7.173.162:8076", //Korean KPOP
            "http://50.7.96.210:8325", //HAWAIIANNNN!
            "http://50.7.98.106:8512", //Bollywood Hindi
        "http://67.23.246.19:8004",//Nigerian
        "http://198.105.220.12:4166/Live",//Arabic
        "http://208.84.135.168:8600",// Filipino
        "http://91.250.77.13:8000/stream/1/", // German
        "http://62.212.82.142:8336",//Greek
        "http://65.19.173.132:2204",//Russian
       };

      static final String[] Classical = 
      {
          "http://91.121.140.11:9000", //Classical Symphony
          "http://184.171.254.134:9940", //Opera
      };
      
      static final String[] Jazz = 
      {
         "http://198.178.123.11:7452", //Swing Jazz
     "http://108.174.52.177:8000/jazz.mp3",//Cool Jazz
      };
      
      static final String[] HipHop =
      {
          "http://108.61.30.179:4030", //Hip Hop1
          "http://108.61.30.179:4010", //Hip Hop 2
      "http://176.31.244.83:9770", //R&B
      };
      
      static final String[] Rap = 
      {
          "http://174.37.110.72:8010", //Gangsta Rap
          "http://192.232.246.172:8036", //Underground
      };
      
      static final String[] Decades = 
      { 
          "http://83.170.104.183:10710", //50's
          "http://108.61.73.119:8132", //60's
          "http://108.61.73.115:8066", //70's
          "http://46.8.37.137:7000", //80's
          "http://108.61.73.117:8012", //90's
          
      };
     
      static final String[] Pop =
      {
          "http://65.60.34.34:9060", //Pop
      "http://198.105.220.12:5478/Live",//Broadway
      

      };
      
      static final String[] Alternative =
      {
          "http://67.228.177.131:8040", //Alternative Rock
          "http://206.217.213.235:8220", //Alternative
        };



        
      String[][] ArrayOfStationLabels = new String[][]{ButtonPRNEWSLabels, ButtonRNRLabels, ButtonSeasonalLabels, ButtonElectronicLabels, 
          ButtonBluesLabels, ButtonCountryLabels, ButtonReggaeLabels, ButtonReligiousLabels, ButtonCulturalLabels, ButtonClassicalLabels,
          ButtonJazzLabels, ButtonHipHopLabels, ButtonRapLabels, ButtonDecadesLabels, ButtonPopLabels, ButtonAlternativeLabels};
          
      //todo
      String[][] ArrayOfStationImages = new String[][]{PRNEWSImages, RNRImages, SeasonalImages, ElectronicImages, 
          BluesImages, CountryImages, ReggaeImages, ReligiousImages, CulturalImages, ClassicalImages,
          JazzImages, HipHopImages, RapImages, DecadesImages, PopImages, AlternativeImages};
        
   
      String[][] ArrayOfStationURLSforG = new String[][]{PRNEWSPaths, RNRPaths, Seasonal, Electronic, Blues, Country, Reggae, Religious, Cultural, 
          Classical, Jazz, HipHop, Rap, Decades, Pop, Alternative};
          
   
  
   
                                       // class constants --------------------//
                                       // (none)                              //
                                       // package instance variables ---------//
                                       // (none)                              //
                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected GvIMediaPlayer mediaPlayer;  // media player                        //
                                       // private instance variables ---------//
                                       // (none)                              //
/*------------------------------------------------------------------------------
  
@name       PjInternetRadio - default constructor
                                                                              */
                                                                             /**
            Default constructor
  
@return     An instance of PjInternetRadio if successful.
  
@history    Sun Nov 27, 2011 08:46:23 (LBM) created.
  
@notes
                                                                              */
//------------------------------------------------------------------------  ------
public PjInternetRadio()
{
   createPanels();


   //Screen.getContentPane().setImage("/Users/user1/Desktop/BlueJ 3.1.0/PumaJFramework/lib/oldradioedit.png");*/
}


    

public void createPanels()
{
    this.setLayout(new BorderLayout(75,50));
  
   
    
    
    JPanel genrePanel = new JPanel();
    this.add(genrePanel, BorderLayout.NORTH);
    genrePanel.setLayout(new GridLayout(0,4, 50,5));  
    
    genrePanel.setOpaque(false);
    genrePanel.setBorder(BorderFactory.createEmptyBorder(25, 50, 10, 50)); //up area, left, down area, right
    
    JPanel mainPanel = new JPanel();
    this.add(mainPanel, BorderLayout.CENTER);
    mainPanel.setLayout(new BorderLayout());
    stationLabelPanel = new JPanel();
    stationLabelPanel.setBackground(new Color(0,0,0,128));
    stationLabelPanel.setOpaque(true);
    
    
    mainPanel.add(stationLabelPanel, BorderLayout.SOUTH);
    stationLabel = new JLabel();
    stationLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    
    stationLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
    stationLabelPanel.add(stationLabel, BorderLayout.SOUTH);
    stationLabelPanel.setVisible(false);
    mainPanel.setOpaque(false);
    
    
    
    JPanel stationPanel = new JPanel();
    mainPanel.add(stationPanel, BorderLayout.CENTER);
    stationPanel.setLayout(new FlowLayout());
    stationPanel.setOpaque(false);
        JLabel expl = new JLabel("Click on a genre to view an array of stations.");
        expl.setFont(new Font("Dialog", Font.PLAIN, 30));
    stationPanel.add(expl,BorderLayout.WEST);
    expl.setForeground(Color.white);
 
     

    
    fillgenreandstationPanel(genrePanel, stationPanel); //method fillgenrePanel and give it the existing genrePanel and do stuff with it
    
    
    JPanel playpausePanel = new JPanel();
    
    this.add(playpausePanel, BorderLayout.SOUTH);
    playpausePanel.setLayout(new GridLayout(0,2, 20, 5));
    playpausePanel.setOpaque(false);
    
    playpausePanel.setBorder(BorderFactory.createEmptyBorder(10, 450, 10, 450));
    
    //expl.setOpaque(false);
    
  
    /*JButton random = new JButton("SURPISE!");
    this.add(random, BorderLayout.EAST);
    random.setOpaque(false);
    random.setLayout(new BorderLayout());*/
  
    
   
   
    
    fillplaypausePanel(playpausePanel);
    
    validate();
}

public void fillplaypausePanel(final JPanel playpausePanel) 
{
    JButton pauseButton = new JButton("Pause");
    playpausePanel.add(pauseButton);
    pauseButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    pauseButton.setBackground(Color.BLACK);
    pauseButton.setForeground(Color.WHITE);
    pauseButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           try
                            {
                  getMediaPlayer().setPaused(true);
                   
               }
             catch(Exception e2)
              {
                  e2.printStackTrace();
             }
                      
        }
      });
      
    JButton playButton = new JButton("Play");
    playpausePanel.add(playButton);
    playButton.setFont(new Font("Dialog", Font.PLAIN, 15));
    playButton.setBackground(Color.BLACK);
    playButton.setForeground(Color.WHITE);
    playButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           try
                            {
                  getMediaPlayer().setPlaying(true);
               
               }
             catch(Exception e2)
              {
                  e2.printStackTrace();
             }
            }
        });
    
    playpausePanel.validate();
}

public void fillgenreandstationPanel(final JPanel genrePanel, final JPanel stationPanel) //type of tha parameter
{
     for(int i =0; i < ButtonGLabels.length; i++) 
    {
     JButton genreButton = new JButton(ButtonGLabels[i]);
     genrePanel.add(genreButton);
     genreButton.setBackground(Color.BLACK);
     genreButton.setForeground(Color.WHITE);
     
     final String[] StationURLList = ArrayOfStationURLSforG[i]; 
     final String[] StationLabelList = ArrayOfStationLabels[i];
     final String[] StationImageList = ArrayOfStationImages[i];
     final String GenreImage = GenreImages[i];
     
     genreButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
                //Clicking a genre
                stationPanel.removeAll();
                
                JLabel background = new JLabel(new ImageIcon(GenreImage));
                PjInternetRadio.this.remove(currentBackground);
                PjInternetRadio.this.add(background);
                currentBackground = background;
                //System.out.println("genre image is " + GenreImage);
                
                 for(int j =0; j < StationURLList.length; j++){ //Stations appear
                     JButton StationButton = new JButton(StationLabelList[j]); // Make all the station buttons
                     StationButton.setBackground(Color.BLACK);
                     StationButton.setForeground(Color.WHITE);
                     StationButton.setFont(new Font("Dialog", Font.PLAIN, 18));
                     final String StationName = StationLabelList[j];
                     // with the labels under the i genre StationLabelList
                     stationPanel.add(StationButton);
                     final String mediaPath = StationURLList[j]; //Get all the URL's from the 
                     // genre StationURL List (get the array of URL's from the array that contains 
                     // the array of URL's )
                     final String stationImage = StationImageList[j];
                        
                    StationButton.addActionListener(new ActionListener() { //Clicking a station
                         public void actionPerformed(ActionEvent e) {
                            try
                            {
                                
                                
                                
                                
                                stationLabel.setText("Now Playing: " + StationName);
                                
                                 
                                
                                stationLabel.setForeground(Color.white);
                                stationLabelPanel.setVisible(true);
                                
                                validate();
                                repaint();
                                
                                JLabel background = new JLabel(new ImageIcon(stationImage));
                                PjInternetRadio.this.remove(currentBackground);
                                PjInternetRadio.this.add(background);
                                currentBackground = background;
                                //System.out.println("station image is " + stationImage);
                                
                                getMediaPlayer().setURI(mediaPath);
                                validate();
                                repaint();
                                //Station plays
                                
                            }
                            catch(Exception e2)
                            {
                                e2.printStackTrace();
                            }
                             
                        }
                    });
                }
                stationPanel.validate();
                validate();
                stationPanel.repaint();
         }
      });
                    
               
         
     }
    genrePanel.validate();
    genrePanel.repaint();
    this.validate();
    this.repaint();
    }
  



/*------------------------------------------------------------------------------
  

@name       getMediaPlayer - get media player
                                                                              */
                                                                             /**
            Get media player instance.
  
@return     media player instance.
  
@history    Sun Nov 27, 2011 08:46:23 (LBM) created.
  
@notes
                                                                              */
//------------------------------------------------------------------------------
public GvIMediaPlayer getMediaPlayer()
{
   if (mediaPlayer == null)
   {
      mediaPlayer = new GvVLCMediaPlayer();
   }
     
   return(mediaPlayer);
}

/*------------------------------------------------------------------------------
 
 
                      
     
/*------------------------------------------------------------------------------
  
@name       main - project main routine
   
  
  
                                                                             */
                                                                             /**
            Project main routine
  
@return     void.
  
@param      args  command line arguments
  
@history    Sun Nov 27, 2011 08:46:23 (LBM) created.
  
@notes
                                                                              */
//------------------------------------------------------------------------------
public static void main(
   String   args[])
{
  /*final JFrame Screen = new JFrame();

   Screen.setSize(814,643);
   Screen.getContentPane().setBackground(Color.blue);
   Screen.getContentPane().setImage("/Users/user1/Desktop/BlueJ 3.1.0/PumaJFramework/lib/oldradioedit.png");*/
  try { 
   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
}
catch (Exception e) {
}
   
   final PjInternetRadio Radio = new PjInternetRadio();
   Radio.setSize(1279,606);
   Radio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    Radio.setVisible(true);
    
    
    System.setProperty("jna.library.path","/Applications/InternetRadio.app/Contents/Resources/lib/vlclib/lib");
   
    Radio.setTitle("ioRAD");
    
    Radio.setLayout(new BorderLayout(50,50));
    JLabel background = new JLabel(new ImageIcon("resources2/ioRADtemp.jpg"));
    Radio.currentBackground = background;
    
    Radio.add(background);
    background.setLayout(new FlowLayout());
    

    Radio.validate();
    Radio.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    


}
}
 
//====================================// end PjInternetRadio -----------------//