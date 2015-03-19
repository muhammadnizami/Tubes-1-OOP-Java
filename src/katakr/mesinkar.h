#ifndef mesinkar_h
#define mesinkar_h

#include <string>
   /*! Kelas mesinkar berguna untuk membaca string input satu per satu
   tidak ada ketergantungan kelas
   */
class mesinkar{
   public:
    /*! konstruktor
   */
   mesinkar();
     /*! konstruktor dengan paramater
   */
   mesinkar (const std::string& _pitakar);
   /*! copy constructor
   */
   mesinkar (const mesinkar& m);
   /*! operator assignment
   */
   mesinkar& operator=(const mesinkar& m);
   /*! destruktor
   */
   ~mesinkar();

   ///Getter
    /*! mengembalikan character yang terakhir dibaca      
   */
   char GetCC() const;
   /*! mengembalikan apakah pembacaan string sudah selesai
   */
   bool GetEnd() const;
   /*! mengembalikan string yang sedang dibaca
   */
   const std::string& GetPitaKarakter() const;
   /*! mengembalikan indeks karakter dalam string yang terakhir dibaca
   */
   int GetIdxChar() const;

   ///Setter
   /*!I.S : Sembarang
   F.S : CC = CT*/   
   void SetCC(char CT); 
   /*!
   I.S : Sembarang
   F.S : End = ET */
   void SetEnd(bool ET);
   /*!I.S : String tidak kosong
   F.S PitaKarakter = ST*/
   void SetPitaKarakter(const std::string& ST); 
   /*!I.S : Sembarang;
   F.S : idxChar = i   */
   void SetIdxChar(int i); 

   ///Fungsi
   /*! I.S : Sembarang
   F.S L idxChar = 0, CC = char PitaKarakter pada idxChar, End = false*/
   void START(); 
   /*! I.S : START() sudah dipanggil
   F.S : idxChar +=1, CC = char PitaKarakter pada idxChar, End = true jika EOP / false jika belum EOP
   */
   void ADV(); 
   /*!
   mengembalikan true jika End == true*/
   bool EOP() const;
   private:
   char CC; 
   bool End;
   std::string PitaKarakter;
   int idxChar;
};
#endif
