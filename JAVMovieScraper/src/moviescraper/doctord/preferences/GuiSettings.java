package moviescraper.doctord.preferences;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;

public class GuiSettings extends Settings {

	enum Key implements Settings.Key {
		lastUsedDirectory,
		lastUsedScraper,
		showOutputPanel,
		showToolbar,
		useContentBasedTypeIcons,		
		;

		@Override
		public String getKey() {
			// prefix setting key to avoid clashing
			return "Gui:" + toString();
		}	
	}
	
	public boolean getShowToolbar(){
		return getBooleanValue(Key.showToolbar, true);
	}
	
	public void setShowToolbar(boolean preferenceValue){
		setBooleanValue(Key.showToolbar, preferenceValue);
	}
	
	public boolean getShowOutputPanel(){
		return getBooleanValue(Key.showOutputPanel, false);
	}
	
	public void setShowOutputPanel(boolean preferenceValue){
		setBooleanValue(Key.showOutputPanel, preferenceValue);
	}
	

	public File getLastUsedDirectory(){
		String lastUsedDir =  getStringValue(Key.lastUsedDirectory, null);

		if(lastUsedDir != null)
		{
			File lastUsedDirFile = new File(lastUsedDir);
			if(lastUsedDirFile.exists())
				return lastUsedDirFile;
			else return new File(System.getProperty("user.home"));
		}
		else return new File(System.getProperty("user.home"));
	}

	public void setLastUsedDirectory(File lastUsedDirectoryFile){
		setStringValue(Key.lastUsedDirectory, lastUsedDirectoryFile.getPath());
	}
	

	public boolean getUseContentBasedTypeIcons() {
	/*    
     * Use icons in res/mime instead of system icons. 
     * Needed for linux as system icons only show two types of icons otherwise (files and folders)
     * There's no menu option for this preference, but you can manually modify the settings file yourself to enable it
     * this option is also automatically enabled on linux
     */

		// if we're on linux we want the content based icons as default        
		boolean defaultValue = SystemUtils.IS_OS_LINUX;

		return getBooleanValue(Key.useContentBasedTypeIcons, defaultValue);
	}

	public void setUseContentBasedTypeIcons(boolean preferenceValue) {
		setBooleanValue(Key.useContentBasedTypeIcons, preferenceValue);    
	}

	public String getLastUsedScraper(){
		return getStringValue(Key.lastUsedScraper, null);
	}
	
	public void setLastUsedScraper(String preferenceValue){
		setStringValue(Key.lastUsedScraper, preferenceValue);
	}
}

