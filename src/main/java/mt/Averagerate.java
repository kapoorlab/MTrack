package mt;

import java.io.File;

public class Averagerate {

	
	public final double averagegrowth;
	public final double averageshrink;
	public final double catfrequ;
	public final double resfrequ;
	public final int growthevent;
	public final int shrinkevent;
	public final int catevent;
	public final int resevent;
	public final File file;

	
	
	public Averagerate(final double averagegrowth,  final double averageshrink,final double catfrequ, final double resfrequ,
			final int growthevent, final int shrinkevent, final int catevent, final int resevent, final File file){
		
		this.averagegrowth = averagegrowth;
		this.averageshrink = averageshrink;
		this.catfrequ = catfrequ;
		this.resfrequ = resfrequ;
	
		this.growthevent = growthevent;
		this.shrinkevent = shrinkevent;
		this.catevent = catevent;
		this.resevent = resevent;
		this.file = file;
		
	}
	
}
