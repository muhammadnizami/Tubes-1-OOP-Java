#include "Token.h"

#include <iostream>
#include <limits>
#include <climits>
#include <cfloat>
#include <cstdlib>
#include <ctime>

int main(){
	srand(time(NULL));

	Token T1,T2,T3;

	//kali
	T1.SetTkn(Kali);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kali);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kali);
	T2.SetBilangan(0);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kali);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kali);
	T2.SetBilangan(rand()%(2000)-1000);
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kali);
	T2.SetBilangan(std::numeric_limits<float>::infinity());
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;


	//bagi
	T1.SetTkn(Bagi);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Bagi);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Bagi);
	T2.SetBilangan(0);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(0.05f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(4e+09f);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(12e+09f);
	T3.SetBilangan(4e+09f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(rand()%(2000)-1000);
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Bagi);
	T2.SetBilangan(std::numeric_limits<float>::infinity());
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	//Div
	T1.SetTkn(Div);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Div);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Div);
	T2.SetBilangan(0);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(0.05f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(4e+09f);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(12e+09f);
	T3.SetBilangan(4e+09f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(rand()%(2000)-1000);
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Div);
	T2.SetBilangan(std::numeric_limits<float>::infinity());
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;
	//Mod
	T1.SetTkn(Mod);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Mod);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" ;
	try{
		std::cout<< T1.Operasikan(T2,T3).ToStr()<<std::endl;
	}catch(TokenException e){
		std::cout << "error: " << e.what() << std::endl;
	}

	T1.SetTkn(Mod);
	T2.SetBilangan(0);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(rand()%(2000000000)-1000000000);
	T3.SetBilangan(rand()%(2000000000)-1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(1000);
	T3.SetBilangan(0.125f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(4e+09f);
	T3.SetBilangan(1000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(12e+09f);
	T3.SetBilangan(4e+09f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(rand()%(2000)-1000);
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Mod);
	T2.SetBilangan(std::numeric_limits<float>::infinity());
	T3.SetBilangan(rand()%(2000)-1000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	//tambah	
	T1.SetTkn(Tambah);
	T2.SetBilangan(1);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Tambah);
	T2.SetBilangan(1);
	T3.SetBilangan(-1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Tambah);
	T2.SetBilangan(-1);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Tambah);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(2000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(4e+09f);
	T3.SetBilangan(2000000000);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(2000000000);
	T3.SetBilangan(4e+09f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(1.5f);
	T3.SetBilangan(0.5f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(1.5f);
	T3.SetBilangan(-0.4f);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(1);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(INT_MIN);
	T3.SetBilangan(INT_MAX);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Kurang);
	T2.SetBilangan(std::numeric_limits<float>::infinity());
	T3.SetBilangan(std::numeric_limits<float>::infinity());
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	//And
	T1.SetTkn(And);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(1);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(0);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(1);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(false);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(true);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(false);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(true);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(0);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(1);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(0);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(1);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(false);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(true);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(false);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(And);
	T2.SetBilangan(true);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	//Or
	T1.SetTkn(Or);
	T2.SetBilangan(0);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(1);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(0);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(1);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(false);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(true);
	T3.SetBilangan(0);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(false);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(true);
	T3.SetBilangan(1);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(0);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(1);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(0);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(1);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(false);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(true);
	T3.SetBilangan(false);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(false);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Or);
	T2.SetBilangan(true);
	T3.SetBilangan(true);
	std::cout << T2.ToStr() << T1.ToStr() << T3.ToStr() << "=" << T1.Operasikan(T2,T3).ToStr()<<std::endl;

	T1.SetTkn(Not);
	T2.SetBilangan(false);
	std::cout << "not " << T2.ToStr() << "="	<<T1.Operasikan(T2).ToStr()<<std::endl;

	T1.SetTkn(Not);
	T2.SetBilangan(true);
	std::cout << "not " << T2.ToStr() << "="	<<T1.Operasikan(T2).ToStr()<<std::endl;

	T1.SetTkn(Not);
	T2.SetBilangan(0);
	std::cout << "not " << T2.ToStr() << "="	<<T1.Operasikan(T2).ToStr()<<std::endl;

	T1.SetTkn(Not);
	T2.SetBilangan(1);
	std::cout << "not " << T2.ToStr() << "="	<<T1.Operasikan(T2).ToStr()<<std::endl;

}
