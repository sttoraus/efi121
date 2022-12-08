public class BubbleSort {

	public static void main(String[] args) {
		int n=30000;
		int []zahlen=new int[n];
		// Bestcase
		for(int i=0;i<n;i++)zahlen[i]=i;
		// Worstcase
		//for(int i=0;i<n;i++)zahlen[i]=n-i;
		long zeitStart=System.currentTimeMillis();
		zahlen=getSortedArray(zahlen);
		long zeitEnde=System.currentTimeMillis();
		System.out.println("Zeit: "+(zeitEnde-zeitStart)+" ms");
	}

	private static float getMedian(int[] zahlen) {
		zahlen=getSortedArray(zahlen);
		int anz=zahlen.length;
		if(anz%2==0) {
			return (zahlen[anz/2]+zahlen[anz/2-1])/2f;
		}
		else {
			return zahlen[anz/2];
		}
	}

	private static int[] getSortedArray(int[] zahlen) {
		int laenge=zahlen.length;
		for(int i=1;i<laenge;i++) {
			for(int j=0;j<laenge-i;j++) {
				if(zahlen[j]>zahlen[j+1]) {
					int tmp=zahlen[j];
					zahlen[j]=zahlen[j+1];
					zahlen[j+1]=tmp;		
				}
			}
		}
		return zahlen;
	}
}
