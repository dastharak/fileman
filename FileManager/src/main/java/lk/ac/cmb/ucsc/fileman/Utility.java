/*
The MIT License

Copyright (c) 2021 Dasun Bamunuarachchi (https://github.com/??)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package lk.ac.cmb.ucsc.fileman;

import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

/**
 *
 * @author UCSC
 */
public class Utility {

    public void setLastException(Throwable lastException) {
        this.lastException = lastException;
        lastError = lastException.getMessage();
    }
    Throwable lastException;
    String lastError;
    
    
    public void print(String ...list){
        String scon = "";
        for(String s :list){
            scon+=s;
        }
        System.out.print(scon);
    }
    
    public int close(Object resource){
        if(resource==null){
            return -1;
        }
        if(resource instanceof FileChannel){
            try{
                ((FileChannel) resource).close();
                return 0;
            }catch(Throwable t){
                lastException = t;
                lastError = t.getMessage();
            }
        }
        return 1;
    }
    
    /**
     * 
     * @param sib - size in bytes
     * @return String representation with appropriate units
     */
    public String convetDataUnits(long sib){
        return (sib<1024)?sib+" bytes":(sib<1048576)?(sib/1024)+" KB":(sib<1073741824)?sib/1048576+" MB":sib/1099511627776l+" GB";
    }
}
