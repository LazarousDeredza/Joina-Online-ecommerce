package com.joina.joinaonline.Joinaonline.helper;

import com.joina.joinaonline.R;
import com.joina.joinaonline.model.master.Category;
import com.joina.joinaonline.model.master.Offer;
import com.joina.joinaonline.model.master.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Data {
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Product> newList = new ArrayList<>();
    List<Product> popularList = new ArrayList<>();
    List<Offer> offerList = new ArrayList<>();

    public List<Category> getCategoryList() {
        Category category = new Category("1", "Medical", R.drawable.icon_medical2);
        categoryList.add(category);
        category = new Category("2", "Food & Drink", R.drawable.food);
        categoryList.add(category);
        category = new Category("3", "Banking", R.drawable.icon_banking1);
        categoryList.add(category);
        category = new Category("4", "Fashion", R.drawable.icon_fashion);
        categoryList.add(category);
        category = new Category("5", "Electronics", R.drawable.icon_electronics1);
        categoryList.add(category);
        category = new Category("6", "Groceries", R.drawable.icon_groceries1);
        categoryList.add(category);
        category = new Category("7", "Entertainment", R.drawable.icon_entertainment1);
        categoryList.add(category);
        category = new Category("8", "Events & Bookings", R.drawable.icon_events);
        categoryList.add(category);
        category = new Category("9", "Online Auction", R.drawable.icon_banking1);
        categoryList.add(category);

        return categoryList;
    }

    public List<Product> getProductList(String category) {

        if(Objects.equals(category, "food & drink")) {

            Product product = new Product("1", "1", "Apple", "", "1 Kg", "Zwl.", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png", "Pizza Hut",R.drawable.pizza_hut);
            productList.add(product);
            product = new Product("2", "1", "Banana", "", "1 Bounch", "Zwl.", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg", "KFC",R.drawable.kfc);
            productList.add(product);
            product = new Product("3", "2", "Orange Crush", "", "1 Lit.", "Zwl.", "25", "", "https://tmpnponline.co.zw/wp-content/uploads/2022/03/5449000062994-Mazoe-Orange-2-Litres.png", "Chicken Hut",R.drawable.chicken_hut);
            productList.add(product);
            product = new Product("4", "2", "Cocacola", "", "1 Piece", "Zwl.", "10", "", "https://tmpnponline.co.zw/wp-content/uploads/2022/03/54491472-Coca-Cola-500ml-1.png", "KFC",R.drawable.kfc);
            productList.add(product);
            product = new Product("6", "4", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png", "Pizza Hut",R.drawable.pizza_hut);
            productList.add(product);
            product = new Product("7", "1", "Litche", "", "1 Kg", "Zwl.", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg", "KFC",R.drawable.kfc);
            productList.add(product);
        }





        else if (category.equals("medical")) {
            Product product = new Product("1", "1", "First Aid Kit", "", "1 Box", "Zwl.", "20", "10% OFF", "https://m.media-amazon.com/images/I/81tfJc3aoOL._AC_UL400_.jpg","Lancet",R.drawable.lancet);
            productList.add(product);
            product = new Product("2", "1", "Bandages", "", "1 Box", "Zwl.", "10", "20% OFF", "https://images.squarespace-cdn.com/content/v1/5715285107eaa055b9fad7fd/1587430200986-QFKVKIKL8GAG05MN3SUQ/SDP-PROD-18-FR.png?format=1500w","Lancet",R.drawable.lancet);
            productList.add(product);
            product = new Product("3", "2", "Hemoglobin Meter kit", "", "1 Kit.", "Zwl.", "25", "", "https://m.media-amazon.com/images/I/71cHUMFpUaL._AC_UL400_.jpg","Lancet",R.drawable.lancet);
            productList.add(product);
            product = new Product("4", "2", "Disposable Syringe", "", "1 Packet", "Zwl.", "10", "", "https://image.made-in-china.com/2f1j00ocZpLTfnOtqg/Disposable-Syringe-Medical-Syringe-With-or-Without-Needle-Luer-Slip-or-Luer-Lock.jpg","Lancet",R.drawable.lancet);
            productList.add(product);
            product = new Product("5", "3", "Medical Latex Gloves", "", "1 Packet", "Zwl.", "20", "10% OFF", "https://image.made-in-china.com/2f1j00gqLpFeJclHkM/Disposable-Medical-Latex-Gloves-Powdered-or-Powder-Free-Sterile-Latex-Surgical-Gloves-Powdered-with-CE-and-ISO.jpg","Lancet",R.drawable.lancet);
            productList.add(product);
            product = new Product("6", "3", "Urinary Drainage Bag", "", "1 Packet", "Zwl.", "31", "", "https://image.made-in-china.com/2f1j00AtgbsyIFnQoR/Medical-2000ml-Urinary-Drainage-Bag-Urine-Bag-with-Push-Pull-Valve-for-Adult.jpg","Lancet",R.drawable.lancet);
            productList.add(product);
        }


        else if (category.equals("banking")) {
            Product product = new Product("1", "1", "Cash Dispenser", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://s.alicdn.com/@sc04/kf/H4bda41134b7f4ee4b1268462a3c9625aj.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
            product = new Product("2", "1", "Money Counter", "", "1 Unit", "Zwl.", "10", "20% OFF", "https://s.alicdn.com/@sc04/kf/H07a1ced4b4fc4d72a013095dd3d9cb57X.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
            product = new Product("3", "2", "ATM Cash Machine", "", "1 Unit.", "Zwl.", "25", "", "https://s.alicdn.com/@sc04/kf/Had9921b94b6f4829a6a34b17f5045743S.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
            product = new Product("4", "2", "Smart Teller", "", "1 Unit", "Zwl.", "10", "", "https://s.alicdn.com/@sc04/kf/H3e250c12d3d3495aa0c4176cf68aa2c40.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
            product = new Product("5", "3", "Card Dispenser", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://s.alicdn.com/@sc04/kf/Hc032257b508e454da751cf27b813a3feH.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
            product = new Product("6", "3", "Money Counter", "", "1 Unit", "Zwl.", "31", "", "https://s.alicdn.com/@sc04/kf/H6e037ffd4b054b89b6e03a009fd33353c.jpg_300x300.jpg","Sterward",R.drawable.steward);
            productList.add(product);
        }




        else if (category.equals("fashion")) {
            Product product = new Product("1", "1", "Baby Gril Fleece", "", "1 Piece", "Zwl.", "20", "10% OFF", "https://image.made-in-china.com/2f1j00nVHbAZeDcKcN/Baby-Boy-Gril-Fleece-One-Piece-with-Hat-for-0-6-Months.jpg","Edgars",R.drawable.edgars);
            productList.add(product);
            product = new Product("2", "1", "Boys PU Jacket", "", "1 Piece", "Zwl.", "10", "20% OFF", "https://image.made-in-china.com/2f1j00LTqcwiElbKgM/Men-Boys-PU-Jacket-Fashion-Apparel-Leather-Clothing-Outdoor-Clothes-Winter-Coat.jpg","POSH",R.drawable.posh);
            productList.add(product);
            product = new Product("3", "2", "Mens Polo", "", "1 Piece.", "Zwl.", "25", "", "https://image.made-in-china.com/2f1j00KUyqDLGgsfcY/Fashion-Customized-OEM-ODM-Mens-Polo-Shirt-Quick-Dry-Summer-Clothing.jpg","Edgars",R.drawable.edgars);
            productList.add(product);
            product = new Product("4", "2", "Chiffon Skirts", "", "1 Piece", "Zwl.", "10", "", "https://image.made-in-china.com/2f1j00hzMqgQaGmubp/Wholesale-New-Fashion-Chiffon-Skirt-Korea-Second-Hand-Clothes-Bales-Used-Clothing.jpg","POSH",R.drawable.posh);
            productList.add(product);
            product = new Product("5", "3", "Dog Vests", "", "1 Piece", "Zwl.", "20", "10% OFF", "https://image.made-in-china.com/2f1j00pZShRfDyHnuT/Summer-Big-Size-Dog-Vests-Fashion-Designer-Pet-Clothes-Pet-Accessories.jpg","Edgars",R.drawable.edgars);
            productList.add(product);
            product = new Product("6", "3", "Baby Garments", "", "1 Piece", "Zwl.", "31", "", "https://image.made-in-china.com/2f1j00vyJifndBckrS/Baby-Garment-Fashion-Baby-Wear-Branded-Logo-Kids-Clothes-for-Autumn-Winter.jpg","POSH",R.drawable.posh);
            productList.add(product);

        }



        else if (category.equals("electronics")) {
            Product product = new Product("1", "1", " Gas Detector", "", "1 Kg", "Zwl.", "20", "10% OFF", "https://image.made-in-china.com/2f1j00jzWYivHZHupk/4-Gas-Portable-Multi-Gas-Detector-LEL-CO-H2S-O2-.jpg","Prosputech",R.drawable.prosputech);
            productList.add(product);
            product = new Product("2", "1", " RJ45 Ethernet", "", "1", "Zwl.", "10", "20% OFF", "https://image.made-in-china.com/2f1j00TngaLOsEANcy/Cat5e-CAT6-UTP-RJ45-Network-Patch-Cord.jpg","Prosputech",R.drawable.prosputech);
            productList.add(product);
            product = new Product("3", "2", "Encapsulated Transformer", "", "1 Lit.", "Zwl.", "25", "", "https://image.made-in-china.com/2f1j00sZlWcvqKkQkb/Three-Phase-Cast-Resin-630kVA-1500kVA-Dry-Type-Distribution-Transformer-Dyn11.jpg","Prosputech",R.drawable.prosputech);
            productList.add(product);
            product = new Product("4", "2", "Gas Detector with Pump", "", "1 Piece", "Zwl.", "10", "", "https://image.made-in-china.com/2f1j00FHecdqDGQKbN/OEM-ODM-CE-Approved-Home-Alarm-CH4-Gas-Leaking-Detector-Protect-Home-Sfety.jpg","Prosputech",R.drawable.prosputech);
            productList.add(product);


        }



        else if (category.equals("groceries")) {
            Product product = new Product("1", "1", "Fiber Shirataki Rice ", "", "1 Kg", "Zwl.", "20", "10% OFF", "https://image.made-in-china.com/2f1j00vKfWHJREVUrt/Survival-Long-Storage-Outdoor-Ready-to-Eat-Curry-Chicken-Fried-Rice-with-Vegetables-5-off.jpg", "PickNPay",R.drawable.pizza_hut);
            productList.add(product);
            product = new Product("2", "1", "Flour Chemical Sugar", "", "1 Bounch", "Zwl.", "10", "20% OFF", "https://image.made-in-china.com/2f1j00PkylhASZMvYp/Manufacturer-25kg-50kg-100kg-Coated-Plastic-Polypropylene-Woven-Flood-Sand-Fertilizer-Rice-Seed-Feed-Biscuit-Flour-Chemical-Sugar-Plastic-Packaging-PP-Bags.jpg", "PickNPay",R.drawable.pizza_hut);
            productList.add(product);
            product = new Product("3", "2", "Pasta Spaghetti", "", "1 Lit.", "Zwl.", "25", "", "https://image.made-in-china.com/2f1j00MNiWLnqEwsoA/Cheapest-Price-Pasta-Spaghetti-250-GM-400GM-500GM-Available-Here-for-Selling.jpg", "PickNPay",R.drawable.pizza_hut);
            productList.add(product);
            product = new Product("4", "2", "Triangle Pyramid Filter Bags", "", "1 Piece", "Zwl.", "10", "", "https://image.made-in-china.com/2f1j00dJnTcuygLUrZ/58-X-70mm-Heat-Sealing-Corn-Fiber-Tea-Bags-PLA-Biodegraded-Tea-Filters-Triangle-Pyramid-Filter-Bags-Could-Customize-Tags.jpg", "PickNPay",R.drawable.pizza_hut);
            productList.add(product);

        }



        else if (category.equals("entertainment")) {
            Product product = new Product("1", "1", "Sound Bars", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://m.media-amazon.com/images/I/71sLWBMa9-L._AC_UY218_.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("2", "1", "Audio Amplifier", "", "1 Unit", "Zwl.", "10", "20% OFF", "https://m.media-amazon.com/images/I/71YDZhcSNQL._AC_UY218_.jpg","Saints N Sinners",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("3", "2", "Home Theatre", "", "1 Unit.", "Zwl.", "25", "", "https://m.media-amazon.com/images/I/71SZ0O2vTFL._AC_UY218_.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("4", "2", "Record Player", "", "1 Unit", "Zwl.", "10", "", "https://m.media-amazon.com/images/I/71C4XWACmrL._AC_UY218_.jpg", "Talk City",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("5", "3", "TV Set", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://m.media-amazon.com/images/I/815Ptr2TKEL._AC_UY218_.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("6", "3", "Smart Projector", "", "1 Unit", "Zwl.", "31", "", "https://m.media-amazon.com/images/I/91mx-rUqN3L._AC_UY218_.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
        }


        else if (category.equals("events & bookings")) {
            Product product = new Product("1", "1", "Clearspan Structures", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://www.rooneys.co.zw/sites/default/files/products/6LgFln5cR9%2B3akfZM3WZWA_thumb_19c77.jpg", "Intervel Inc",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("2", "1", "Premier Marquees", "", "1 Unit", "Zwl.", "10", "20% OFF", "https://www.rooneys.co.zw/sites/default/files/products/freeform1.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("3", "2", "Barriers and Fencing", "", "1 Unit.", "Zwl.", "25", "", "https://www.rooneys.co.zw/sites/default/files/products/IMG-20230313-WA0008.jpg", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("4", "2", "Flooring", "", "1 Unit", "Zwl.", "10", "", "https://www.rooneys.co.zw/sites/default/files/products/IMG_8965.JPG", "Ster-Kinekor",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("5", "3", "Climate Control", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://www.rooneys.co.zw/sites/default/files/products/DSC_1037.JPG", "Intervel Inc",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("6", "3", "Peg & Pole Marquees", "", "1 Unit", "Zwl.", "31", "", "https://www.rooneys.co.zw/sites/default/files/products/IMG_2103.JPG", "Ster-Kinekor",R.drawable.dark_logo);

        }


        else if (category.equals("online auction")) {
            Product product = new Product("1", "1", "CupBoard", "", "1 Unit", "Zwl.", "20", "10% OFF", "https://auctioneers.co.zw/wp-content/uploads/2023/07/p-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("2", "1", "Sofas", "", "4 Piece", "Zwl.", "10", "20% OFF", "https://auctioneers.co.zw/wp-content/uploads/2023/07/sofas-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("3", "2", "Howo Bus", "", "1 Unit.", "Zwl.", "25", "", "https://auctioneers.co.zw/wp-content/uploads/2023/07/r-4-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("4", "2", "Mazda 626", "", "1 Unit", "Zwl.", "10", "", "https://auctioneers.co.zw/wp-content/uploads/2023/07/m-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("5", "3", "Dining Suite", "", "4 Piece", "Zwl.", "20", "10% OFF", "https://auctioneers.co.zw/wp-content/uploads/2023/07/a-3-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);
            product = new Product("6", "3", "Couch", "", "3 Piece", "Zwl.", "31", "", "https://auctioneers.co.zw/wp-content/uploads/2023/07/o-300x224.jpg",  "LGOt Good Auction",R.drawable.dark_logo);
            productList.add(product);

        }

        return productList;
    }

    public List<Product> getNewList() {
        Product product = new Product("1", "1", "Apple", "", "1 Kg", "Zwl.", "20", "10% OFF", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        newList.add(product);
        product = new Product("2", "1", "Banana", "", "1 Bounch", "Zwl.", "10", "20% OFF", "https://images-na.ssl-images-amazon.com/images/I/21DejQuoT2L.jpg");
        newList.add(product);
        product = new Product("3", "2", "House Clean Liquid", "", "1 Lit.", "Zwl.", "25", "", "http://sunsetcleaningcia.com/wp-content/uploads/2016/05/houseclean.png");
        newList.add(product);
        product = new Product("4", "2", "House Clean Brush", "", "1 Piece", "Zwl.", "10", "", "https://www.clean-hoouse.com/wp-content/uploads/2017/09/13.png");
        newList.add(product);
        product = new Product("5", "3", "Pampers", "", "1 Piece", "20", "Zwl.", "10% OFF", "https://cdn.bmstores.co.uk/images/hpcProductImage/imgFull/311448-Pampers-Baby-Dry-Size-4-Maxi-251.jpg");
        newList.add(product);
        return newList;
    }

    public List<Product> getPopularList() {
        Product product = new Product("6", "3", "Baby Oil", "", "500 Ml", "Zwl.", "31", "", "https://www.fortunaonline.net/media/catalog/product/cache/1/small_image/295x/040ec09b1e35df139433887a97daa66f/n/k/nkbcp12_-_xia-shib-ao-baby-oil-200ml.png");
        popularList.add(product);
        product = new Product("7", "4", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("8", "4", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("9", "5", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("10", "5", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("11", "6", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("12", "6", "Apple", "", "1 Kg", "Zwl.", "20", "", "https://storage.googleapis.com/zopnow-static/images/products/320/fresh-apple-red-delicious-v-500-g.png");
        popularList.add(product);
        product = new Product("13", "1", "Litche", "", "1 Kg", "Zwl.", "20", "30%OFF", "https://cdn.shopify.com/s/files/1/0665/4989/products/lichee-485x400_grande.jpg");
        popularList.add(product);
        return popularList;
    }

    public List<Offer> getOfferList() {
        Offer offer = new Offer("http://1.bp.blogspot.com/-MMt-60IWEdw/VqZsh45Dv8I/AAAAAAAAMHg/70D9tVowlyc/s1600/askmegrocery-republic-day-offer.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.lootkaro.com/wp-content/uploads/2016/05/as1.jpg");
        offerList.add(offer);
        offer = new Offer("https://453xbcknr3t3ahr522mms518-wpengine.netdna-ssl.com/wp-content/themes/iga-west/images/banner-save-more.jpg");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/SVD/July18/750x375.png");
        offerList.add(offer);
        offer = new Offer("https://images-eu.ssl-images-amazon.com/images/G/31/img16/Grocery/BreakfastStore/kmande_2018-06-15T12-00_f010a5_1121973_grocery_750x375.jpg");
        offerList.add(offer);
        offer = new Offer("http://www.enjoygrocery.com/images/enjoygrocery-offer.jpg");
        offerList.add(offer);


        return offerList;
    }
}
