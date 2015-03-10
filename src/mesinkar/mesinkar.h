/*
NAMA/NIM : 135135061/Lucky Cahyadi Kurniawan
FILE     : mesinkar.h
TANGGAL  : 5 Maret 2014
*/
#include <string>
class mesinkar{
   public:
   mesinkar();
   ~mesinkar();
   //Getter
   char GetCC();
   bool GetEnd();
   std::string GetPitaKarakter();
   int GetIdxChar();
   //Setter
   void SetCC(char CT);
   void SetEnd(bool ET);
   void SetPitaKarakter(std::string& ST);
   void SetIdxChar(int i);
   //Fungsi
   void START();
   void ADV();
   bool EOP();
   
   private:
   char CC;
   bool End;
   std::string PitaKarakter;
   int idxChar;
};
