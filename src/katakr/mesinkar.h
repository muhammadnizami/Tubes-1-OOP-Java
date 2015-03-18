#ifndef mesinkar_h
#define mesinkar_h

#include <string>

class mesinkar{
   /*! Kelas mesinkar berguna untuk membaca string input satu per stau
   */
   public:
   mesinkar();
   /*! konstruktor
   */
   mesinkar (const std::string& _pitakar);
   /*! konstruktor dengan paramater
   */
   mesinkar (const mesinkar& m);
   /*! copy constructor
   */
   mesinkar& operator=(const mesinkar& m);
   /*! operator assignment
   */
   ~mesinkar();
   /*! destruktor
   */
   ///Getter
   char GetCC() const;
   /*! mengembalikan character yang terakhir dibaca      
   */
   bool GetEnd() const;
   /*! mengembalikan apakah pembacaan string sudah selesai
   */
   const std::string& GetPitaKarakter() const;
   /*! mengembalikan string yang sedang dibaca
   */
   int GetIdxChar() const;
   /*! mengembalikan indeks karakter dalam string yang terakhir dibaca
   */
   ///Setter
   void SetCC(char CT); 
   /*!I.S : Sembarang
   F.S : CC = CT*/
   void SetEnd(bool ET); /*!
   I.S : Sembarang
   F.S : End = ET */
   void SetPitaKarakter(const std::string& ST); 
   /*!I.S : String tidak kosong
   F.S PitaKarakter = ST*/
   void SetIdxChar(int i); 
   /*!I.S : Sembarang;
   F.S : idxChar = i   */
   ///Fungsi
   void START(); 
   /*! I.S : Sembarang
   F.S L idxChar = 0, CC = char PitaKarakter pada idxChar, End = false*/
   void ADV(); 
   /*! I.S : START() sudah dipanggil
   F.S : idxChar +=1, CC = char PitaKarakter pada idxChar, End = true jika EOP / false jika belum EOP
   */
   bool EOP() const; /*!
   mengembalikan true jika End == true*/
   private:
   char CC; 
   bool End;
   std::string PitaKarakter;
   int idxChar;
};
#endif
