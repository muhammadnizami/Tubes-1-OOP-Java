public interface StrToken{
    //!mengembalikan true bila s dapat dikonversi ke token
   bool canConvert(final String s);
  //!mengembalikan representasi string dari token T
   String toString (final Token T);
  //!mengembalikan representasi token dari string s
   Token toToken(final String s); 
}
