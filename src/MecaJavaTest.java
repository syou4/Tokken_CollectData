import org.chasen.mecab.*;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MecaJavaTest {
	static {
		try {
			System.loadLibrary("MeCab");
		} catch (UnsatisfiedLinkError e) {
			System.err.println(
					"Cannot load the example native code.\nMake sure your LD_LIBRARY_PATH contains \'.\'\n" + e);
			System.exit(1);
		}
	}

	public static void main(String[] argv) {
		Tagger tagger = new Tagger();
		//String str = "太郎は二郎に本を渡した。なぜその本を三郎に渡さなかったのか？";

		try {
			File file = new File(argv[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));

			String str = br.readLine();
			while (str != null) {
				// System.out.println(tagger.parse(str));
				tagger.parse(str);
				Node node = tagger.parseToNode(str);
				for (; node != null; node = node.getNext()) {
					// System.out.println("表記語：" + node.getSurface());
					String[] features = node.getFeature().split(",");
					if (features[0].equals("名詞")) {
						System.out.println(node.getSurface());
					}
					/*
					 * System.out.println(features[0]);
					 * System.out.println(features[1]);
					 * System.out.println(features[2]);
					 * System.out.println(features[3]);
					 * System.out.println(features[4]);
					 * System.out.println(features[5]);
					 * System.out.println(features[6]);
					 * System.out.println(features[7]); System.out.println();
					 */

				}
				str = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}
	// System.out.println ("EOS\n");
}
