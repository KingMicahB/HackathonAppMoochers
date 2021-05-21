/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalfriendconnector;

/**
 *
 * @author kingm
 */
public class Animal {
    private String name;
    private String imageLoc;
    private String soundLoc;
    public Animal(String name, String imageLoc, String soundLoc)
    {
        setName(name);
        setImageLoc(imageLoc);
        setSoundLoc(soundLoc);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imageLoc
     */
    public String getImageLoc() {
        return imageLoc;
    }

    /**
     * @param imageLoc the imageLoc to set
     */
    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }

    /**
     * @return the soundLoc
     */
    public String getSoundLoc() {
        return soundLoc;
    }

    /**
     * @param soundLoc the soundLoc to set
     */
    public void setSoundLoc(String soundLoc) {
        this.soundLoc = soundLoc;
    }
}
