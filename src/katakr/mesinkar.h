#ifndef mesinkar_h
#define mesinkar_h

#include <string>

class mesinkar{
   public:
   mesinkar();
   mesinkar (const std::string& _pitakar);
   mesinkar (const mesinkar& m);
   mesinkar& operator=(const mesinkar& m);
   ~mesinkar();
   //Getter
   char GetCC() const;
   bool GetEnd() const;
   const std::string& GetPitaKarakter() const;
   int GetIdxChar() const;
   //Setter
   void SetCC(char CT);
   void SetEnd(bool ET);
   void SetPitaKarakter(const std::string& ST);
   void SetIdxChar(int i);
   //Fungsi
   void START();
   void ADV();
   bool EOP() const;
   private:
   char CC;
   bool End;
   std::string PitaKarakter;
   int idxChar;
};
#endif