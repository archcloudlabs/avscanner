package com.archcloudlabs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import org.junit.Test;


public class FScanTest {

    @Test
    public void ObjCreationTest() throws IOException{
        
        FScan fs = new FScan();
        assertNotNull(fs);
    }

    @Test
    public void ReadDataFailTest() throws IOException{
        
        File fpath = new File("this/path/does/not/exist");
        FScan fs = new FScan();
       assertFalse(fpath.exists());
    }

    
}
