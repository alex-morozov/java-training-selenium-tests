package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;
import org.testng.annotations.Test;

import com.example.fw.GroupData;
import com.example.utils.SortedListOf;



public class GroupRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeGroup (){		
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();	
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size()-1);
		
	    app.getGroupHelper().deleteGroup(index);  
	   
	    
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();	
	    
	    assertThat(newList, equalTo(oldList.without(index)));	    
	}


}
