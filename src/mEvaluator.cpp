#include "Evaluator.h"
#include <iostream>
#include <string>

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::getline;

int main(){
	Evaluator E;
	std::string cmd;
	cout<<"Ini untuk debug saja, masukkan perintah yang benar"<<endl;
	cout<<"Postfix Evaluator. expr:"<<endl<<"> ";
	getline(cin,cmd);
	cout<<E.ComputeExprPostfix(cmd)<<endl;
}