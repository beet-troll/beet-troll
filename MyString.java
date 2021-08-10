package hw2;

/**
 * 
 * A class that mimics how Java's String class behaves without using the String class
 * in any way.
 *
 */
public class MyString {
	private char[] data;

	/**
	 * Constructs a <code>MyString</code> object to represent the text in
	 * <code>string</code>
	 * @param string a <code>char</code> array containing the characters
	 * 		  of the text we are representing.
	 */
	public MyString(char[] string) {
		data = string;
	}

	public char charAt(int i) {
		return data[i];
	}

	public int length() {
		return data.length;
	}

	/**
	 * Returns the index of the first occurrence of c in the MyString if
	 * c is present; otherwise, -1 is returned.
	 * 
	 * @param c the character to find
	 * @return the index of the first occurrence of c in the MyString if
	 * c is present; otherwise, -1 is returned.
	 */
	public int indexOf(char c) {
	       for (int i = 0; i < length(); i++) {
	           if (data[i] == c)
	               return i;
	       }
	       return -1;
	   }

	/**
	 * Returns true if <code>this</code> MyString and <code>other</code> reresent
	 * the same string (have the same characters at the same positions) and false
	 * otherwise.
	 * 
	 * @param other the other <code>MyString</code> to compare with.
	 * @return true if <code>this</code> MyString and <code>other</code> reresent
	 * the same string (have the same characters at the same positions) and false
	 * otherwise.
	 */
	public boolean equals(MyString other) {
		int len = length();
	       if (len != other.length())
	           return false;
	       else {
	           for (int i = 0; i < len; i++) {
	               if (data[i] != other.data[i])
	                   return false;
	           }
	       }
	       return true;
	   }
	
	/**
	 * A lexicographical comparison of <code>this MyString</code> to <code>other</code>.
	 * The comparison is case sensitive, meaning it might not return the correct answer
	 * if the text being compared isn't all the same case.
	 * 
	 * @param other the <code>MyString<code> to compare against.
	 * @return a negative number if <code>this</code> appears before <code>other</code>
	 * in the dictionary, a positive number if <code>this</code> appears after
	 * <code>other</code> in the dictionary, and 0 if <code>this</code> and <code>other</code>
	 * represent the same <code>String</code>
	 */
	public int compareTo(MyString other) {
	      int len1 = data.length;
	      int len2 = other.data.length;
	      int length = Math.min(len1, len2);
	      if (len1==0) 
	      if(len2==0) {
	      return 0;
	      }
	      if (len1 > len2)
	      {return 1;}
	      else if (len1 == len2)
	      {for (int i = 0; i < length;)
	         {if (this.charAt(i) > other.charAt(i))
	         {return 1;}
	          else if (this.charAt(i) < other.charAt(i))
	          {return -1;}
	           else
	           {return 0;}}}
	      {return -1;}}
	
	/**
	 * Returns a <code>MyString</code> resulting from replacing all occurrences of <code>oldChar</code>
	 * in this string with <code>newChar</code>.  If the character <code>oldChar</code> does not occur
	 * in the character sequence represented by this <code>MyString</code> object, then a reference to
	 * this <code>MyString</code> object is returned. Otherwise, a <code>MyString</code> object is
	 * returned that represents a character sequence identical to the character sequence represented by
	 * this <code>MyString</code> object, except that every occurrence of <code>oldChar</code> is
	 * replaced by an occurrence of <code>newChar</code>.
	 * @param oldChar the old character
	 * @param newChar the new character
	 * @return a <code>MyString</code> resulting from replacing all occurrences of <code>oldChar</code>
	 * in this string with <code>newChar</code>
	 */
	   public MyString replace(char oldChar, char newChar) {
		   boolean flag=false;
		   char[] newData=new char [data.length];
		   for(int i=0;i<newData.length;i++) {
			   newData[i]=data[i];
		   }
		   for(int i=0;i<newData.length;i++)
		   {
		       if(newData[i]==oldChar)
		       
		    	   {flag=true;
		           newData[i]=newChar;}}
		       
		       if (flag==false) 
		       { return this;}
		   else
			   {return new MyString(newData);}}
		   
	   }
		
