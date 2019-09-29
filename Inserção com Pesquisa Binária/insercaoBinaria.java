for(int i = 1; i < n; i++) {
	int tmp = array[i];
	inicio = 0;
	fim = i;

	while(inicio < fim) {
		meio = (inicio + fim) / 2;
		if(array[meio] <= tmp) {
			inicio = meio + 1;
		} else {
			fim = meio;
		}
	}

	for(int j = i; j > fim; j--) {
		array[j] = array[j - 1];
		array[fim] = tmp;
	} 
}