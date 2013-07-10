/*                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.*/

package plt.help;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;



/**
 *
 * @author user
 */
public class JsonHelpExtractor implements IHelpExtractor
{
    @Override
    public HashMap<String, String> extractToolTipFile(String para_filePath)
    {
        
        FileReader fReader = obtainFReader(para_filePath);
        
        HashMap<String,String> strHMap = new HashMap<String,String>();
        Gson gson = new Gson();
        strHMap = gson.fromJson(fReader,strHMap.getClass());
        
        return strHMap;
    }

    @Override
    public HashMap<String, String> extractExtensiveHelpFile(String para_filePath, String[] para_reqHelpItemIDs)
    {
        FileReader fReader = obtainFReader(para_filePath);
        
        HashMap<String,String> strHMap = new HashMap<String,String>();
        Gson gson = new Gson();
        strHMap = gson.fromJson(fReader,strHMap.getClass());
        
        
        HashMap<String,String> retHMap = new HashMap<String,String>();
        for(int i=0; i<para_reqHelpItemIDs.length; i++)
        {
            String tmpKey = para_reqHelpItemIDs[i];
            
            if(strHMap.containsKey(tmpKey))
            {
                retHMap.put(tmpKey, strHMap.get(tmpKey));
            }
        }
        
        
        return retHMap;
    }
    
    public HashMap<String,ExtensiveHelp> extractExtensiveHelpFile(String para_filePath)
    {
        FileReader fReader = obtainFReader(para_filePath);
        
        HashMap<String,ExtensiveHelp> eMap = new HashMap<String,ExtensiveHelp>();
        Gson gson = new Gson();
        Type reqType = new TypeToken<HashMap<String,ExtensiveHelp>>() {}.getType();
        eMap = gson.fromJson(fReader, reqType);
        
        return eMap;
    }
    
    public void writeExtensiveHelpFile(String para_fileName)
    {
        
        
        try
        {
            FileWriter fWriter = new FileWriter(para_fileName);
            
            String helpItemID1 = "HELP ITEM";
            HashMap<String,String> sections1 = new HashMap<>();
            sections1.put("Section 1.1", "This is section 1 of "+helpItemID1);
            sections1.put("Section 1.2", "This is section 2 of "+helpItemID1);
            ArrayList<String> sectionOrderList1 = new ArrayList<>();
            sectionOrderList1.add("Section 1.1");
            sectionOrderList1.add("Section 1.2");
            ExtensiveHelp tmpEHelp1 = new ExtensiveHelp(sectionOrderList1,sections1);

            String helpItemID2 = "HELP ITEM 2";
            HashMap<String,String> sections2 = new HashMap<>();
            sections2.put("Section 2.1", "This is section 1 of "+helpItemID2);
            sections2.put("Section 2.2", "This is section 2 of "+helpItemID2);
            ArrayList<String> sectionOrderList2 = new ArrayList<>();
            sectionOrderList2.add("Section 2.1");
            sectionOrderList2.add("Section 2.2");
            ExtensiveHelp tmpEHelp2 = new ExtensiveHelp(sectionOrderList2, sections2);

            HashMap<String,ExtensiveHelp> eMap = new HashMap<>();
            eMap.put(helpItemID1, tmpEHelp1);
            eMap.put(helpItemID2, tmpEHelp2);

            Gson gson = new Gson();
            String jsonResStr = gson.toJson(eMap);
            fWriter.write(jsonResStr);
            
            fWriter.close();
        }
        catch(IOException ex)
        {
            System.out.println("IOException");
            ex.printStackTrace();
            return;
        }      
    }
    
    private FileReader obtainFReader(String para_filePath)
    {
        FileReader fReader;
        try
        {
            fReader = new FileReader(para_filePath);
            return fReader;
        }
        catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
