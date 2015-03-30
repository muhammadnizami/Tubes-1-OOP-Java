public interface StrToken{
    //!mengembalikan true bila s dapat dikonversi ke token
   bool canConvert(String s);
  //!mengembalikan representasi string dari token T
   String toString (Token T);
  //!mengembalikan representasi token dari string s
   Token toToken(String s); 
}
