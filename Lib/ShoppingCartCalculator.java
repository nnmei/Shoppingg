
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * @param items ราคาสินค้าและจำนวนสินค้า ห้ามใส่ค่าติดลบ ถ้าติดลบราคาจะ 0.0 ถ้าใส่ค่า null จะได้ 0.0
     * @return ส่งค่าราคา normal ; ไม่มีส่วนลด
     * BOGO ; ซ์้อ 1 แถม 1
     * BULK ; ซื้อมากกว่า 5 ชิ้น ได้ส่วนลด 10%
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {

        if ( items == null || items.isEmpty() ) {
            return 0.0;
        }
        //double price = 0.00;
        double total = 0.00;
        for( int i = 0 ; i < items.size() ; i++ ) {
            double price = 0.00;
            int quantity = 0;
            
        //if ( items.get(i).price() < 0 ||  items.get(i).quantity() < 0 )
            if ("BOGO" == items.get(i).sku() && items.get(i).price() > 0 ){
                quantity = items.get(i).quantity()/2;
                price = quantity*items.get(i).price();
            }
            else if ("BULK" == items.get(i).sku() && items.get(i).price() > 0) {
                if ( items.get(i).quantity() > 5 ) {
                    price = (items.get(i).price() * items.get(i).quantity())*0.9;
                }
                else {
                    price = (items.get(i).price() * items.get(i).quantity());
                }
            }
            else {
                if ( items.get(i).price() < 0 ||  items.get(i).quantity() < 0 ) {
                    price = 0.0;
                }
                else {
                price = items.get(i).price() * items.get(i).quantity();
                }
            }

            total += price;
        }

        return total;

    }
}