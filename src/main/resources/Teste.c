void funcao1(){
	float NotaDaP1, NotaDaP2;
	float Media;
	clrscr(); // Limpa a tela
	NotaDaP1 = 6.6; // Atribui��o do Valores das m�dias
	NotaDaP2 = 8.2;
	Media = (NotaDaP1 + NotaDaP2) / 2.0;
	printf("M�dia Final : %6.3f", Media);
	// No momento da execu��o sinal %6.3f vai ser substitu�do
	// pelo valor da vari�vel Media
	// M�dia Final : 7.400
	getch(); // espera que o usu�rio pressione uma tecla
}

int funcao2(){
	int num;
	string s;
	printf ("Digite um n�mero: ");
	scanf ("%d",&num);
	if (num>10){
	printf ("\n\n O n�mero e maior que 10");
	s = "errou";
	}
	if (num==10){
	printf ("\n\n Voc� acertou!\n");
	printf ("O numero � igual a 10.");
	s = "acertou";
	}
	if (num<10){
	printf ("\n\n O n�mero � menor que 10");
	s = "errou";
	}
	if(num == 10 && s == "acertou"){
	return 1;
	}
	return 0;
}
int main(){
	funcao1();
	funcao2();
	return 1;
}