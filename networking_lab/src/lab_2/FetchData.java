package lab_2;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchData {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://whatismyipaddress.com/").userAgent("mozilla\17.0").get();
			Elements temp = doc.select("div.ip-address-list");
			for(Element ip:temp) {
				System.out.println(ip.getElementsByTag("p").first().text());
			}
			
			Elements temp1 = doc.select("div.ip-iformation");
			for(Element details:temp1) {
				System.out.println(details.getElementsByTag("p").first().text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
