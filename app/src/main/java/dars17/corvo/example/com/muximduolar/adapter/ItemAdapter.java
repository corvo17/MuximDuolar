package dars17.corvo.example.com.muximduolar.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import dars17.corvo.example.com.muximduolar.App;
import dars17.corvo.example.com.muximduolar.Const;
import dars17.corvo.example.com.muximduolar.IndudualDuo;
import dars17.corvo.example.com.muximduolar.R;
import dars17.corvo.example.com.muximduolar.db.Item;
import dars17.corvo.example.com.muximduolar.db.ItemDAO;
import dars17.corvo.example.com.muximduolar.db.ItemDB;

import static android.content.ContentValues.TAG;

public class ItemAdapter extends ListAdapter<Item, ItemAdapter.StudentViewHolder> {
    private Context context;
    private ItemDB itemDB;
    List<Item> lovedItems;


    public ItemAdapter(Context context, ItemDB itemDB) {
        super(new ItemCallBack());
        lovedItems = new ArrayList<>();
        this.context = context;
        this.itemDB = itemDB;
    }

    @NonNull
    @Override public ItemAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_items, parent, false);
        return new ItemAdapter.StudentViewHolder(v);
    }

    @Override public void onBindViewHolder(@NonNull ItemAdapter.StudentViewHolder holder, int position) {
        holder.favourImg.setOnClickListener(new ItemAdapter.Listener(position));
//        notifyAll();
        holder.text.setOnClickListener(new ItemAdapter.Listener(holder.text.getId(), true,position));
        Const.smoothScrollPosition = position;


        holder.onBind(getItem(position));
    }


    class StudentViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;
        public ImageView favourImg;
        public CardView myCV;

        public StudentViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.CVIV);
            text = itemView.findViewById(R.id.textview1);
            favourImg = itemView.findViewById(R.id.imageView);
            //todo
            myCV = itemView.findViewById(R.id.CV);
        }

        @SuppressLint("SetTextI18n") void onBind(Item item) {
            if (item.isFavour == 0){
                image.setImageResource(item.imgRes);
                text.setText(item.text);
                //favourImg.setImageResource(R.drawable.ic_favorite_red_24dp);
            }
            if (item.isFavour == 1) {
                image.setImageResource(item.imgRes);
                text.setText(item.text);
                favourImg.setImageResource(R.drawable.ic_favorite_red_24dp);
                //   lovedItems.remove(item);
            }
//            if(item.isFavour){
//                favourImg.setImageResource(R.drawable.ic_favorite_red_24dp);
//            }

//            tvAge.setText("age: " + student.age);
//            tvName.setText("name: " + student.name);
//            tvSurName.setText("surName: " + student.surName);
        }

    }
    class Listener implements View.OnClickListener
    {
        private ItemDAO dao;
        private int position;
        private int myId;
        //List<Item> items;
        public Listener(int position) {
            this.position = position;
            initDB();
        }
        public Listener(int id, boolean is, int position){
            Const.smoothScrollPosition = position;
            initDB();
            this.myId = id;
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == myId ){
                TextView tv = (TextView) view;
                String text = tv.getText().toString();
                switch (text){
                    case "Kiyim kiyishda":{
                        String []myString = new String[8];
                        myString[0] = "KIYIM KIYISHDA";
                        myString[1] =  R.drawable.kiyim_kiyishda3 + "";
                        myString[2] =  "Kiyim kiyishdan oldin o‘qiladigan duo:";
                        myString[3] =  "الْحَمْدُ للَّهِ الَّذِي كَسَانِي هَذَا (الثَّوْبَ) وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّة";
                        myString[4] =  "Abu Dovud 4023, At-Tirmizi 3458, ibnu Mojax 3285. Xadis priemlemiy,  \n Qo`shimcha: Iryaul’-G’alil’ 7/47.";
                        myString[5] =  R.raw.dua5 + "";
                        myString[6] =  "Alhamdulillahillaziy kasanuhaza (assabva) varozaqnihim meng'oyrixavlin munni vala quvvat";
                        myString[7] =  "Menga bu kiyimni kiydirgan va uni menga mening kuch-qudratimsiz nasib etgan Allohga hamdlar bo‘lsin. \n" + "\n"+

                                "XADIS:\n" +
                                "«Kiyim kiyadigan bo'lganlaringizda yoki tahorat olishingizda tanangizning o'ng tarafidan boshlang»  \nXadis keltirganlar: Abu Dovud, At-Termizi, Ibn Mojar, Bayxaqiy.";
                        Intent intent = new Intent(context, IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Kiyim yechishda":{
                        String []myString = new String[8];
                        myString[0] = "KIYIM YECHISHDA";
                        myString[1] =  R.drawable.kiyim_yechishda2 + "";
                        myString[2] =  "Kiyim yechishdan oldin o‘qiladigan duo:";
                        myString[3] =  "بسمِ اللَّه";
                        myString[4] =  "Dalil  At-Tirmizi (606), \n Qo`shimcha:  Saxixul’-Djami’ (3/203, 3610).";
                        myString[5] =  R.raw.bismillah + "";
                        myString[6] =  "Bismillah";
                        myString[7] =  "Bismillah (ya’ni Olloh nomi ila yechaman).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Xojatxonaga kirishda":{
                        String []myString = new String[8];
                        myString[0] = "XOJATXONAGA KIRISHDA";
                        myString[1] =  R.drawable.xojatxonaga_kirish2 + "";
                        myString[2] =  "Xojatxonaga kirishdan oldin quyidagicha duo qilishi kerak:";
                        myString[3] =  "بسمِ اللَّه ) اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْخُبْثِ وَالْخَبائِثِ)";
                        myString[4] =  "Al’-Buxoriy(142), Muslim (375). \n Qo`shimcha: Fatxul’-Bari (1/244)";
                        myString[5] =  R.raw.dua10 + "";
                        myString[6] =  "(Bismillahi) Allohumma inni a’uzu bika minal hubsi val xobais";
                        myString[7] =  "Bismillah, (Ollohning nomini yodga olib kiraman.) Parvardigoro! Men Sendan erkak va urg`ochi shaytonlarning yomonligidan asrashingni so`rayman.\n" +
                                "\n" +
                                "Qazoi hojat va istinjo odoblari:\n"+
                                "\n" +
                                "Qazoi hojatni o‘tirgan holda qiladi, faqat o‘tira olmaydigan uzri bo‘lsa, turgan holda qazoi hojat qiladi.\n" +
                                "\n" +
                                "Qazoi hojat vaqtida, istinjo va toshga artayotgan holatida bosh kiyim bilan Allohdan va maloikalardan hayo qilgan holda o‘tiradi.\n" +
                                "\n" +
                                "Qabr ustiga qazoi hojat qilish yoki keng dala bo‘ladimi, biror bino ichi bo‘ladimi, qiblaga yuzlanib yoki orqa qilib o‘tirish ham makruhi tahrimiydir, ya’ni haromga yaqin makruh. To‘xtab turgan oz suvga hojat qilish haromdir, agar to‘xtab turgan suv ko‘p bo‘lsa, unga hojat qilish makruhi tahrimiydir. Agar suv oquvchi bo‘lsa, unga hojat qilish makruhi tanzihiy bo‘ladi. Bu degani suvga peshob qilsa bo‘ladi, degani emas. Faqat bu erda mas’ala sifatida keltirilmoqda. Suvxonalarga, suv oqib keladigan erlarga, insonlar yuradigan, salqinlab o‘tiradigan, to‘planadigan joylarga qazoi hajot qilish makruhdir. Yana hojat vaqtida gapirishlik, tili bilan Alloh taoloni zikr qilishlik, quyosh yoki oyga yuzlanib o‘tirishlik ham makruhdir. Istinjo deb, najosat chiqadigan o‘rinlarni suv bilan tozalash, istijmor esa tosh bilan tozalashga aytiladi. Bu erkaklarga va ayollarga sunnati muakkadadir. Lekin najosat maxrajga ya’ni najosat chiqadigan o‘ringa dirham miqdoridan ko‘proq yoyilgan bo‘lsa, kesak yoki varaqning o‘zi kifoya qilmaydi, balki suv bilan yuvish vojib bo‘ladi. Istinjoni chap qo‘l bilan qilish mustahab amaldir. Istinjoni qog‘oz ishlatib so‘ng suv bilan yuvish faqat biri bilan kifoyalangandan ko‘ra afzal hisoblanadi.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Xojatxonadan chiqishda":{
                        String []myString = new String[8];
                        myString[0] = "XOJATXONADAN CHIQISHDA";
                        myString[1] =  R.drawable.xojatxonadan_chiqishda + "";
                        myString[2] =  "Xojatxonadan chiqqandan so‘ng o‘qiladigan duo:";
                        myString[3] =  "غُفْرَانَكَ";
                        myString[4] =  "At-Tirmizi (7), Abu Dovud (30), ibnu Mojax (300), \n Qo`shimcha: Taxridj Zadul’-Ma’ad (2/386), Saxix Sunan abu Daud (1/19).";
                        myString[5] =  R.raw.dua11 + "";
                        myString[6] =  "G'ufronak";
                        myString[7] =  "Mag‘firat etishingni so‘rayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yangi kiyim kiyganda":{
                        String []myString = new String[8];
                        myString[0] = "YANGI KIYIM KIYGANDA";
                        myString[1] =  R.drawable.yangi_kiyim_kiyganda2 + "";
                        myString[2] =  "Yangi kiyim kiyganda o'qiladigan duo:";
                        myString[3] =  "تُبْلِي وَيُخْلِفُ اللَّهُ تَعَالَى";
                        myString[4] =  "Abu Dovud (4020),  \n Qo`shimcha: Saxix Abu Daud (2/760).";
                        myString[5] =  R.raw.dua7 + "";
                        myString[6] =  "Tuvli vayuxlefullohu ta'ala";
                        myString[7] =  "Kiyimingiz eskirib, Olloh taolo yana yangisini nasib etaversin.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yangi kiyim kiyganda 2":{
                        String []myString = new String[8];
                        myString[0] = "YANGI KIYIM KIYGANDA";
                        myString[1] =  R.drawable.yangi_kiyim_kiyganda2 + "";
                        myString[2] =  "Abu Said Xudriy roziyallohu anhu rivoyat qiladilar: \"Rasululloh sollallohu alayhi vasallam yangi ko'ylak, rido yoki salla kiysalar, bismillohni aytib, quydagi duvoni aytar edilar:";
                        myString[3] =  " اللَّهُمَّ لَكَ الْحَمْدُ ، أَنْتَ كَسَوْتَنِيهِ ، أَسْأَلُكَ مِنْ خَيْرِهِ وَخَيْرِ مَا صُنِعَ لَهُ ، وَأَعُوذُ بِكَ مِنْ شَرِّهِ وَشَرِّ مَا صُنِعَ لَهُ";
                        myString[4] =  "Abu Dovud rivoyati";
                        myString[5] =  R.raw.yangi_kiyim2 + "";
                        myString[6] =  "Allohumma lakal hamdu anta kasavtaniyhi, as'aluka min xoyrihi va xoyri maa suni'a lahu va a'uzu bika min shirrihi va sharri maa suni'a lahu.";
                        myString[7] =  "Allohim! Senga hamd bo'lsin! Sen buni menga kiyguzding. Sendan uning yaxshiligini va unga beriladigan narsalarning yaxshisini so'rayman. Uning hamda unga qilinadigan yomonligidan panoh tilayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uxlashdan avval":{
                        String []myString = new String[8];
                        myString[0] = "UXLASHDAN AVVAL";
                        myString[1] =  R.drawable.uxlashdan_avval2 + "";
                        myString[2] =  "Duoga qo’l ochib, unga dam urib, bismillohni aytib, quydagi suralarni o’qiymiz.\n" +
                                "Duodan so’ng qollarimizni tanamiz boylab surtamiz, boshimizdan boshlaymiz,  yuz va tananing old qismiga surtamiz. (Barchasini uch marotaba takrorlaymiz):";
                        myString[3] = "IXLOS SURASI\n" +
                                "قُلْ هُوَ اللَّهُ أَحَدٌ \n" +
                                "اللَّهُ الصَّمَدُ \n" +
                                "لَمْ يَلِدْ وَلَمْ يُولَدْ \n" +
                                "وَلَمْ يَكُن لَّهُ كُفُوًا أَحَدٌ \n" +
                                "FALAQ SURASI\n" +
                                "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ \n" +
                                "مِن شَرِّ مَا خَلَقَ \n" +
                                "وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ \n" +
                                "وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ \n" +
                                "وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ \n" +
                                "AN-NOS SURASI\n" +
                                "قُلْ أَعُوذُ بِرَبِّ النَّاسِ \n" +
                                "مَلِكِ النَّاسِ \n" +
                                "إِلَهِ النَّاسِ \n" +
                                "مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ \n" +
                                "الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ \n" +
                                "مِنَ الْجِنَّةِ وَ النَّاسِ \n";
                        myString[4] =  "Abu Dovud (1523), at-Tirmizi 2903, an-Nasai (3/68),  \n Qo`shimcha: Saxixul-Tirmizi (2/8). Fatxul’-Bari 9/62.";
                        myString[5] =  R.raw.ihlas_falaq_nnas + "";
                        myString[6] = "IXLOS SURAS\n" +
                                "Qul huvallohu ahad. \n" +
                                "Allohus-somad. \n" +
                                "Lam yalid. Va lam yuvlad \n" +
                                "va lam yakullahu kufuvan ahad.\n" +
                                "\n" +
                                "\nFALAQ SURASI\n" +
                                "Qul a’uzu birobbil falaq. \n" +
                                "Min sharri ma xolaq. \n" +
                                "Va min sharri g‘osiqin iza vaqob. \n" +
                                "Va min sharrin-naffasati fil ‘uqod. \n" +
                                "Va min sharri hasidin iza hasad.\n"+
                                "\n" +
                                "\nAN-NOS SURASI\n" +
                                "Qul a’uzu birrobin-nasi \n" +
                                "malikin-nasi \n" +
                                "ilahin-nasi \n" +
                                "min sharril vasvasil xonnas. \n" +
                                "Allaziy yuvasvisu fiy sudurin-nasi\n" +
                                "minal jinnati van-nas.\n";
                        myString[7] = "Ixlos surasi" +
                                "\n" +
                                "(Ey Muhammad,) ayting: «U — Alloh yagonadir. Alloh behojat, (lekin) hojatbarordir. U tug'magan va tug'ilmagan ham. Shuningdek, Unga teng biror zot yo'qdir»." +
                                "\n" +
                                "\nAl-Falaq surasi\n" +
                                "«(Ey Muhammad,) ayting: \"Panoh tilab iltijo qilurman tong Parvardigoriga yaratgan narsasi yovuzligidan, tugunchaga dam uruvchi ayollar yovuzligidan hamda hasadchining hasadi yovuzligidan»." +
                                "\n" +
                                "\nAn-Nas surasi\n" +
                                "«(Ey Muhammad,) ayting: \"Panoh tilab iltijo qilurman odamlar Parvardigoriga, odamlar Podshohiga, odamlar Ilohiga yashirin vasvasachi (shayton) yovuzligidanki, (u) odamlarning dillariga vasvasa solur. (O'zi) jinlar va odamlardandir\"».\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uxlashdan avval 2":{
                        String []myString = new String[8];
                        myString[0] = "UXLASHDAN AVVAL";
                        myString[1] =  R.drawable.uxlashdan_avval2 + "";
                        myString[2] =  "Abu Hurayra roziyallohu anhudan rivoyat qilinadi: Payg'ambarimiz sollallohu alayhi vasallam:";
                        myString[3] =  "بِاسْمِكَ رَبِّي وَضَعْتُ جَنْبِي، وَبِكَ أَرْفَعُهُ، فَإِن أَمْسَكْتَ نَفْسِي فارْحَمْهَا، وَإِنْ أَرْسَلْتَهَا فَاحْفَظْهَا، بِمَا تَحْفَظُ بِهِ عِبَادَكَ الصَّالِحِينَ";
                        myString[4] =  "Imom Buxoriy rivoyati ";
                        myString[5] =  R.raw.dua102 + "";
                        myString[6] = "Bismika Robbiy va zo'tu jambiy va bika arfa'uhu, fa in amsakta nafsiy farhamha, va in arsaltaha fahfazha bima tahfazu bihi ibadaka ssolihiyn.\n";
                        myString[7] = "«Agar sizlardan birontangiz tushagiga yotmoqchi bo'lsa, to'shagini va izorini qoqib yuborsin. Albatta, u ularda nima borligini bilmaydi va: «Parvardigoro Seni noming bilan uxladim va Seni noming bilan uyg'onaman. Agar, jonimni olsang O'z rahmatinga ol. Agar tirik uyg'otsang xuddi solih bandalaringni muhofaza etganingdek muhofaza et», desin» dedilar.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uyqusida cho'chiganda":{
                        String []myString = new String[8];
                        myString[0] = "UYQUSIDAN CHO`CHIB KETGANDA";
                        myString[1] =  R.drawable.uyqusida_chochiganda2 + "";
                        myString[2] =  "Uyqusidan cho`chib ketib, vahima bosib qo'rqqanida quyidagi duo o`qiladi:";
                        myString[3] =  "لاَ إِلَهَ إِلاَّ اللَّهُ الْوَاحِدُ الْقَهّارُ، رَبُّ السَّمَوَاتِ وَالْأَرْضِ وَمَا بَيْنَهُمَا الْعَزيزُ الْغَفَّارُ";
                        myString[4] =  "ibnu Sunni 757. Saxixul’-Djomi’ 4/213";
                        myString[5] =  R.raw.dua112 + "";
                        myString[6] = "La ilaha illallohu l‘-Vahudu l‘-Qohhar.\n" +
                                "Robbu s-samavati va-l‘-arzu va ma bayna-huma l‘-Azizu l‘-G’offar. \n";
                        myString[7] = "Allohdan boshqa ibodatga loyiq iloh yo'q, osmonlar, er va ularning orasidagi mavjud narsalarning Xudosi - Allohdir. U Ulug ' va kechirimlidir.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yomon tush ko'rganda":{
                        String []myString = new String[8];
                        myString[0] = "YOMON TUSH KO`RGANDA";
                        myString[1] =  R.drawable.yomon_tush2 + "";
                        myString[2] =  "Uyqusida yomon tush ko`rganda o`qiladigan duo:";
                        myString[3] =  "أَعُوذُ بِكَلِمَاتِ اللَّهِ التَّامَّاتِ مِنْ غَضَبِهِ وَعِقَابِهِ، وَشَرِّ عِبَادِهِ، وَمِنْ هَمَزَاتِ الشَّياطِينِ وَأَنْ يَحْضُرُونَِِ";
                        myString[4] =  "Abu Doud 3893, at-Tirmizi 3528. Saxixul-Tirmizi 3/171 ";
                        myString[5] =  R.raw.dua113 + "";
                        myString[6] = "A’uzu bi kalimatillahit-tammatu min g’ozobihi va ‘iqobihi va sharru ibadihi va min hamazatish-shayatini va ay-yahzuruni";
                        myString[7] = "Men Allohning g'azabidan, azobidan va bandalarining yomonligidan, shaytonlarning ta'limotidan va menga zohir bo'lib kelganidan mukammal so'zlar bilan murojaat qilaman.(TEKSHIRISH KERAK).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uyqudan uyg`onganda":{
                        String []myString = new String[8];
                        myString[0] = "UYQUDAN UYG`ONGANDAN SO`NG";
                        myString[1] =  R.drawable.uyqudan_uygonganda2 + "";
                        myString[2] =  "Uyqudan uyg`ongandan so`ng aytiladigan duo:";
                        myString[3] =  "الْحَمْدُ لِلَّهِ الَّذِي عَافَانِي فِي جَسَدِي، وَرَدَّ عَلَيَّ رُوحِي، وَأَذِنَ لي بِذِكْرِهَِِِ";
                        myString[4] =  "at-Tirmizi 3401, Saxix at-Tirmizi 3/144 ";
                        myString[5] =  R.raw.dua3 + "";
                        myString[6] = "Alhamdulillahillaziy  ʼafaniy fiy jasadiy, va rodda ʼalayya ruhiy, va azina liy bizikrihi";
                        myString[7] = "Mening jismimga ofiyat ato etgan, menga ruhimni qaytargan va O‘zining zikriga meni qodir qilgan Allohga hamdlar bo‘lsin.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uyqudan uyg`onganda 2":{
                        String []myString = new String[8];
                        myString[0] = "UYQUDAN UYG`ONGANDAN SO`NG";
                        myString[1] =  R.drawable.uyqudan_uygonganda2 + "";
                        myString[2] =  "Uyqudan uyg`ongandan so`ng aytiladigan duo:";
                        myString[3] =  "الْحَمْدُ للَّهِ الَّذِي أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُورُ";
                        myString[4] =  "Al’-Buxari 6314, Muslim (2711)";
                        myString[5] =  R.raw.dua1 + "";
                        myString[6] = "Alhamdulillahillaziy ahyana ba'da ma amatana va ilayhin nushur";
                        myString[7] = "Bizni o‘ldirgandan so‘ng qayta tiriltirgan Allohga hamdu sanolar bo‘lsin. Qayta tirilish Uning huzurigadir.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uyqudan uyg`onganda 3":{
                        String []myString = new String[8];
                        myString[0] = "UYQUDAN UYG`ONGANDAN SO`NG";
                        myString[1] =  R.drawable.uyqudan_uygonganda2 + "";
                        myString[2] =  "Uyqudan uyg`ongandan so`ng aytiladigan duo:";
                        myString[3] =  "لَا إِلَهَ إِلَّا اللّهُ وَحْدَهُ لاَ شَريكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، سُبْحَانَ اللّهِ، وَالْحَمْدُ للَّهِ، وَلَا إِلَهَ إِلَّا اللّهُ، وَاللّه أَكبَرُ، وَلاَ حَوْلَ وَلاَ قُوَّةَ إِلاَّ بِاللّهِ الْعَلِيِّ الْعَظِيمِ، رَبِّ اغْفرْ لِيَِِِ";
                        myString[4] =  "al’-Buxari 1154, Saxix ibnu Madjax 2/335";
                        myString[5] =  R.raw.dua2 + "";
                        myString[6] = "La ilaha illallohu vahdahu la sharikalahu, lahul-mulku valahul-hamdu, va huva ʼala kulli shayʼin Qodir. Subhanallohi, valhamdulillahi, vala ilaha illallohu, vallohu akbar, vala havla, vala quvvata illa billahil-ʼAliyyil-ʼAziym. Robbigʻfirliy.";
                        myString[7] = "Allohdan o‘zga iloh yo‘q, U yolg‘iz sheriksiz zotdir. Barcha mulk Unikidir, hamdlar ham Unga xosdir va U hamma narsaga qodir zotdir. Olloh aybu nuqsondan pokdir, hamdu sanolar Unga xosdir va Ollohdan o‘zga hech qanday iloh yo‘q. Olloh buyukdir. Kuch-qudrat ham yolg‘iz oliy va ulug‘ Olloh madadi iladir. Robbim meni mag‘firat qilgil.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uydan chiqishda":{
                        String []myString = new String[8];
                        myString[0] = "UYDAN CHIQISHDA";
                        myString[1] =  R.drawable.uydan_chiqanda2 + "";
                        myString[2] =  "Uydan chiqishda o'ng oyoq bilan qadam tashlab chiqiladi, chiqishda quydagicha duo qilinadi:";
                        myString[3] =  "بِسْمِ اللَّهِ، تَوَكَّلْتُ عَلى اللَّهِ، وَلَا حَوْلَ وَلَا قُوَّةَ إِلاَّ بِاللَّهِ";
                        myString[4] =  "At-Tirmizi (3426), Abu Dovud (5095), Qo'shimcha: «Saxixut-Tirmizi» (3/151)";
                        myString[5] =  R.raw.dua16 + "";
                        myString[6] = "BismiLlahi, tavakkaltu ‘alalllohi, vala havla vala quvvata illa billahi";
                        myString[7] = "Alloh nomi bilan va men Allohga tayanaman, kuch va qudrat egasi, Allohdir. (tarjima quydagicha ham bo`lishi mumkin:…Allohdan o‘zga kuz-qudrat beruvchi yo‘qdir).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uydan chiqishda 2":{
                        String []myString = new String[8];
                        myString[0] = "UYDAN CHIQISHDA 2";
                        myString[1] =  R.drawable.uydan_chiqanda2 + "";
                        myString[2] =  "Uydan chiqishda o'ng oyoq bilan qadam tashlab chiqiladi, chiqishda quydagicha duo qilinadi:";
                        myString[3] =  "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ أَنْ أَضِلَّ، أَوْ أُضَلَّ، أَوْ أَزِلَّ، أَوْ أُزَلَّ، أَوْ أَظْلِمَ، أَوْ أُظْلَمَ، أَوْ أَجْهَلَ، أَوْ يُجْهَلَ عَلَيَّ";
                        myString[4] =  "Abu Dovud (5094), at-Tirmizi (3427), an-Nasai (5501), Ibnu Majar (3884), Qo'shimcha: Saxix ibnu Majar (2/336), Saxixut-Tirmizi (3/152)";
                        myString[5] =  R.raw.dua17 + "";
                        myString[6] = "Allohumma  inni a‘uzubika an\n" +
                                "azilla, av azolla, av azilla, av \n" +
                                "azolla, av azlim, av azlam, av\n" +
                                "ajhal, av ajhal ‘alayx\n";
                        myString[7] = "Ey Allohim, men Sendan yo‘lda adashishdan, to‘g’ri yo‘ldan chiqin ketishdan, xato qilib qo’yishdan, noto'g'ri xatti-harakat bilan o‘zgalarga nisbatan adolatsiz munosabatda bo'lishdan, menga ham nisbatan adolatsiz munosabatda bo’lishlaridan, johillardan, va meni johil sanashlaridan panoh so'rayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Uyga kirishda":{
                        String []myString = new String[8];
                        myString[0] = "UYDAN KIRISHDA";
                        myString[1] =  R.drawable.uyga_kirishda2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam: “Kishi uyiga kirganda:";
                        myString[3] =  "بِسْمِ اللهِ وَلَجْنَا وَبِسْمِ اللهِ خَرَجْنَا وَعَلَى رَبِّنَا تَوَكَّلْنَا";
                        myString[4] =  "Abu Dovud rivoyati";
                        myString[5] =  R.raw.uyga_kirish + "";
                        myString[6] = "Bismillahi valajnaa va bismillaahi xorojnaa va ‘ala Robbina tavakkalna";
                        myString[7] = "“Allohning ismi bilan kirdik. Allohning ismi bilan chiqdik. Rabbimizga tavakkal qildik”, deb aytib, so’ngra ahliga salom bersin, dedilar.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Manzilga yetganda":{
                        String []myString = new String[8];
                        myString[0] = "MANZILGA YETGANDA";
                        myString[1] =  R.drawable.manzilga_yetganda2 + "";
                        myString[2] =  "Manzilga yetganda quydagicha duo qilish avzal:";
                        myString[3] =  "بِسْـمِ اللهِ وَلَجْنـا، وَبِسْـمِ اللهِ خَـرَجْنـا، وَعَلـى رَبِّنـا تَوَكّلْـنا";
                        myString[4] =  "Abu Dovud (5096), Zaif Xadis. Dalil «Da'if Kalimatu-t-Tayyib» (1/91). Sahihi Muslimda  (2018) quydagi hadis keladi: \"Bir kishi uyiga kirsa va kiraverishda va taom paytida Allohni yod etgan bo'lsa, shayton, sheriklariga: \"Siz uchun hech qanday boshpana va kechki ovqat yoq\", deydi.\"";
                        myString[5] =  R.raw.dua18 + "";
                        myString[6] = "Bismillahi valajna, bi bismillahi xorojna, va ‘ala Robbana tavakkalna";
                        myString[7] = "Biz Allohning nomi bilan kirib, Allohning nomi bilan chiqdik va Rabbimizga imon keltirdik.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi duo":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI DUO";
                        myString[1] =  R.drawable.tongiduo2 + "";
                        myString[2] =  "Tong otayotganda qilinadigan duo:";
                        myString[3] =  "اللَّهُمَّ إنِّي أَسْأَلُكَ عِلْماً نَافِعاً، وَرِزْقاً طَيِّباً، وَعَمَلاً مُتَقَبَّلا";
                        myString[4] =  "Ibn Moja va Ibn Sunniy rivoyati";
                        myString[5] =  R.raw.tongduo + "";
                        myString[6] = "Allohumma inniy asaluka ‘ilman naafi’an va rizqon toyyiban va ‘amalan mutaqobbalan";
                        myString[7] = "Allohim! Sendan foydali ilm, pokiza rizq, qabul bo‘ladigan amal so‘rayman." +
                                "\n" +
                                "\n" +
                                "TONGGI VA KECHKI DUOLARNING SAMARA VA NATIJALARI\n" +
                                "\n" +
                                "Har bir musulmon tonggi va kechki zikr-duolarni doimiy ravishda aytish orqali uning manfaatlaridan bahramand bo‘lishi mumkin. Quyida tonggi va kechki duolarni muntazam takrorlash orqali mo‘min inson erishishi mumkin bo‘lgan samara va natijalarni sanab o‘tamiz:\n" +
                                "\n" +
                                "1. Alloh taoloning rizosiga erishadi.\n" +
                                "2. Shaytonning hiyla-nayranglaridan uzoqlashishiga sabab bo‘ladi.\n" +
                                "3. Yurakdagi g‘am-tashvishlari ariydi.\n" +
                                "4. Jismi va ruhiyatida kuch paydo qiladi. \n" +
                                "5. Allohning zikrida bo‘lish qalb, aql va yuzni nurlantiradi.\n" +
                                "6. Rizq-ro‘z va barakaning kelishiga sabab bo‘ladi.\n" +
                                "7. Musulmon kishi Allohni zikr etish orqali Allohga yaqinlashayotganini va shu orqali qilgan zikrlari ehson darajasiga etib, ya’ni Alloh uni kurib turgandek ibodat qilayotganini sezadi.\n" +
                                "8. Agar musulmon kishi doimiy ravishda Allohning zikrida bo‘lsa, Alloh taolo ham uning o‘zidan ziyodroq eslaydi. Hadiysi Qudusiyda bu haqda shunday deyiladi: \"Alloh taolo aytadi... Meni bir o‘zi eslasa, Men ham uni O‘zim eslayman. Agar u Meni bir jamoa ichida eslasa, Men uni ulardan yaxshiroq jamoa ichida eslayman...\"\n" +
                                "(Buxoriy rivoyati)\n" +
                                "9. Boshqalar tomonidan mo‘min insonga dushmanlik qilib zarar etkazish niyatida qilingan sehr-jodu, yomon amallardan halos bo‘lish uchun qo‘rg‘on bo‘ladi va Allohning hifzu himoyasida ekanini his qilib, huzurlanishi uchun bemorning o‘zi bu duolarni ertayu kech takrorlashi tavsiya qilinadi.\n" +
                                "10. Nazar-nafas va ko‘z tegishidan saqlovchi vosita hisoblanadi.\n" +
                                "11. Mo‘min insonning juz’iy xato va gunohlari kechirilib, uning xayrli va savob ishlari orttiriladi.\n" +
                                "12. Sog‘liqni, inson a’zolarini turli kasalliklardan hamda kufr, kambag‘allik va qabr azobidan panoh topishiga sabab bo‘ladi.\n" +
                                "13. Xuddi hadisi sharifda zikr qilingandek: \"Unga biror narsa zarar bermaydi\".\n" +
                                "\n" +
                                "Alloh taolo aytadi:\n" +
                                "\"Parvardigoringizni ichingizda yolvorib, qo‘rqib, dildan ertayu-kech yod qiling va g‘ofil kimsalardan bo‘lmang!\"\n" +
                                "(\"A’rof\" surasi, 205-oyat)\n" +
                                "Doniyor qori\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi duo 2":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI DUO 2";
                        myString[1] =  R.drawable.tongiduo2 + "";
                        myString[2] =  "Abu Hurayradan roziyallohu anhudan rivoyat qilinadi. Rasululloh sollallohu alayhi vasallam: «Kim:";
                        myString[3] =  "لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌٌ";
                        myString[4] =  "Buxoriy va Muslim rivoyati";
                        myString[5] =  R.raw.tongduo2 + "";
                        myString[6] = "Laa ilaaha illallohu vahdahu laa shariyka lah, lahul mulku va lahul hamdu va huva ‘ala kulli shay`in qodiyr";
                        myString[7] = "deb bir kunda yuz marta aytsa, o‘nta qul ozod qilgan barobarida bo‘libdi. Unga yuzta hasanot yozilib, yuzta yomonligi o‘chiriladi, kech kirgunicha shaytondan omonda bo‘ladi. Uning bu amalidan afzalroq ishni hech kim qila olmaydi. Faqat shu kalimalarni ko‘proq aytgan kishi o‘zib ketishi mumkin», dedilar.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi zikir":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI ZIKIR ISTIG‘FOR";
                        myString[1] =  R.drawable.tongiduo2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam: «... Albatta men ham har kuni Alloh taologa yuz marta istig‘for aytaman», dedilar.";
                        myString[3] =  "أَسْتَغْفِرُ اللهَ وَأَتُوبُ إِلَيْهِ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.istigfor + "";
                        myString[6] = "Astag‘firulloha va atuubu ilayhi";
                        myString[7] = "Allohdan mag‘firat qilishini so‘rayman va Unga tavba qilaman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi zikir 2":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI ZIKIR 2";
                        myString[1] =  R.drawable.tongiduo2 + "";
                        myString[2] =  "Tong otganda 3 marta aytiladi:";
                        myString[3] =  "سُبْحَانَ اللهِ وَبِحَمْدِهِ: عَدَدَ خَلْقِهِ، وَرِضَا نَفْسِهِ، وَزِنَةَ عَرْشِهِ وَمِدَادَ كَلِمَاتِهِ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.tongzikir + "";
                        myString[6] = "Subhaanallohi va bihamdihi, ‘adada xolqihi va rizoo nafsihi va zinata ‘arshihi va midaada kalimaatihi";
                        myString[7] = "Yaratganlarining adadicha, nafsi rozi bo‘lgunicha, Arshning vaznicha, kalimalarining uzunligicha Allohga hamd aytaman va Uni poklayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Kechggi duo":{
                        String []myString = new String[8];
                        myString[0] = "KECHGGI DUO";
                        myString[1] =  R.drawable.kechgiduo2 + "";
                        myString[2] =  "Abu Hurayra roziyallohu anhu aytadilar:  «Rasululloh sollallohu alayhi vasallam huzurlariga bir kishi kelib: «Ey Rasululloh, kecha meni chayon chaqib oldi», dedi. Shunda Nabiy sollallohu alayhi vasallam: «Kech kirganida: «A’uuzu bikalimaatillahit taammaati min sharri ma xolaq», desang, senga hech narsa zarar bermaydi»,  dedilar.";
                        myString[3] =  "أَعُوذُ بِكَلِمَاتِ اللهِ التَّامَّاتِ مِنْ شَرِّ مَا خَلَقَ";
                        myString[4] =  "Muslim rivoyati. Boshqa rivoyatni: Termiziy, Ahmad, Nasoiy, va Ibn Moja rivoyati";
                        myString[5] =  R.raw.kechgiduo + "";
                        myString[6] = "A’uuzu bikalimaatillahit taammaati min sharri ma xolaq";
                        myString[7] = "Allohning hamma kalimalari bilan U yaratgan narsalarning yomonligidan panoh tilayman. Boshqa rivoyatda esa: «Shu duoni kech kirganda 3 marta o‘qigan kishiga tunning zarari etmaydi» deyilgan." +
                                "\n" +
                                "\n" +
                                "TONGGI VA KECHKI DUOLARNING SAMARA VA NATIJALARI\n" +
                                "\n" +
                                "Har bir musulmon tonggi va kechki zikr-duolarni doimiy ravishda aytish orqali uning manfaatlaridan bahramand bo‘lishi mumkin. Quyida tonggi va kechki duolarni muntazam takrorlash orqali mo‘min inson erishishi mumkin bo‘lgan samara va natijalarni sanab o‘tamiz:\n" +
                                "\n" +
                                "1. Alloh taoloning rizosiga erishadi.\n" +
                                "2. Shaytonning hiyla-nayranglaridan uzoqlashishiga sabab bo‘ladi.\n" +
                                "3. Yurakdagi g‘am-tashvishlari ariydi.\n" +
                                "4. Jismi va ruhiyatida kuch paydo qiladi. \n" +
                                "5. Allohning zikrida bo‘lish qalb, aql va yuzni nurlantiradi.\n" +
                                "6. Rizq-ro‘z va barakaning kelishiga sabab bo‘ladi.\n" +
                                "7. Musulmon kishi Allohni zikr etish orqali Allohga yaqinlashayotganini va shu orqali qilgan zikrlari ehson darajasiga etib, ya’ni Alloh uni kurib turgandek ibodat qilayotganini sezadi.\n" +
                                "8. Agar musulmon kishi doimiy ravishda Allohning zikrida bo‘lsa, Alloh taolo ham uning o‘zidan ziyodroq eslaydi. Hadiysi Qudusiyda bu haqda shunday deyiladi: \"Alloh taolo aytadi... Meni bir o‘zi eslasa, Men ham uni O‘zim eslayman. Agar u Meni bir jamoa ichida eslasa, Men uni ulardan yaxshiroq jamoa ichida eslayman...\"\n" +
                                "(Buxoriy rivoyati)\n" +
                                "9. Boshqalar tomonidan mo‘min insonga dushmanlik qilib zarar etkazish niyatida qilingan sehr-jodu, yomon amallardan halos bo‘lish uchun qo‘rg‘on bo‘ladi va Allohning hifzu himoyasida ekanini his qilib, huzurlanishi uchun bemorning o‘zi bu duolarni ertayu kech takrorlashi tavsiya qilinadi.\n" +
                                "10. Nazar-nafas va ko‘z tegishidan saqlovchi vosita hisoblanadi.\n" +
                                "11. Mo‘min insonning juz’iy xato va gunohlari kechirilib, uning xayrli va savob ishlari orttiriladi.\n" +
                                "12. Sog‘liqni, inson a’zolarini turli kasalliklardan hamda kufr, kambag‘allik va qabr azobidan panoh topishiga sabab bo‘ladi.\n" +
                                "13. Xuddi hadisi sharifda zikr qilingandek: \"Unga biror narsa zarar bermaydi\".\n" +
                                "\n" +
                                "Alloh taolo aytadi:\n" +
                                "\"Parvardigoringizni ichingizda yolvorib, qo‘rqib, dildan ertayu-kech yod qiling va g‘ofil kimsalardan bo‘lmang!\"\n" +
                                "(\"A’rof\" surasi, 205-oyat)\n" +
                                "Doniyor qori\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi va kechgi":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI VA KECHGI DUO";
                        myString[1] =  R.drawable.tongvakechgiduo2 + "";
                        myString[2] =  "Tong otganda va kech kirganda o`qiladigan duo:";
                        myString[3] =  "يَا حَيُّ يَا قَيُّومُ بِرَحْمَتِكَ أَسْتَغِيثُ أَصْلِحْ لِي شَأْنِي كُلَّهُ، وَلَا تَكِلْنِي إِلَى نَفْسِي طَرْفَةَ عَيْنٍَ";
                        myString[4] =  "Termiziy va Nasoiy rivoyati";
                        myString[5] =  R.raw.tongvakechgi + "";
                        myString[6] = "Ya Hayyu, Ya Qoyyuum, birohmatika astag‘iys, aslih liy shaniy kullahu va laa takilniy ilaa nafsiy torfata ‘ayn";
                        myString[7] = "Ey hamisha Barhayot va abadiy Turuvchi bo‘lgan Zot! Sendan yordam so‘rayman. Ishimni hammasini isloh et va meni ko‘z ochib yumguncha ham o‘z holimga tashlab qo‘yma." +
                                "\n" +
                                "\n" +
                                "TONGGI VA KECHKI DUOLARNING SAMARA VA NATIJALARI\n" +
                                "\n" +
                                "Har bir musulmon tonggi va kechki zikr-duolarni doimiy ravishda aytish orqali uning manfaatlaridan bahramand bo‘lishi mumkin. Quyida tonggi va kechki duolarni muntazam takrorlash orqali mo‘min inson erishishi mumkin bo‘lgan samara va natijalarni sanab o‘tamiz:\n" +
                                "\n" +
                                "1. Alloh taoloning rizosiga erishadi.\n" +
                                "2. Shaytonning hiyla-nayranglaridan uzoqlashishiga sabab bo‘ladi.\n" +
                                "3. Yurakdagi g‘am-tashvishlari ariydi.\n" +
                                "4. Jismi va ruhiyatida kuch paydo qiladi. \n" +
                                "5. Allohning zikrida bo‘lish qalb, aql va yuzni nurlantiradi.\n" +
                                "6. Rizq-ro‘z va barakaning kelishiga sabab bo‘ladi.\n" +
                                "7. Musulmon kishi Allohni zikr etish orqali Allohga yaqinlashayotganini va shu orqali qilgan zikrlari ehson darajasiga etib, ya’ni Alloh uni kurib turgandek ibodat qilayotganini sezadi.\n" +
                                "8. Agar musulmon kishi doimiy ravishda Allohning zikrida bo‘lsa, Alloh taolo ham uning o‘zidan ziyodroq eslaydi. Hadiysi Qudusiyda bu haqda shunday deyiladi: \"Alloh taolo aytadi... Meni bir o‘zi eslasa, Men ham uni O‘zim eslayman. Agar u Meni bir jamoa ichida eslasa, Men uni ulardan yaxshiroq jamoa ichida eslayman...\"\n" +
                                "(Buxoriy rivoyati)\n" +
                                "9. Boshqalar tomonidan mo‘min insonga dushmanlik qilib zarar etkazish niyatida qilingan sehr-jodu, yomon amallardan halos bo‘lish uchun qo‘rg‘on bo‘ladi va Allohning hifzu himoyasida ekanini his qilib, huzurlanishi uchun bemorning o‘zi bu duolarni ertayu kech takrorlashi tavsiya qilinadi.\n" +
                                "10. Nazar-nafas va ko‘z tegishidan saqlovchi vosita hisoblanadi.\n" +
                                "11. Mo‘min insonning juz’iy xato va gunohlari kechirilib, uning xayrli va savob ishlari orttiriladi.\n" +
                                "12. Sog‘liqni, inson a’zolarini turli kasalliklardan hamda kufr, kambag‘allik va qabr azobidan panoh topishiga sabab bo‘ladi.\n" +
                                "13. Xuddi hadisi sharifda zikr qilingandek: \"Unga biror narsa zarar bermaydi\".\n" +
                                "\n" +
                                "Alloh taolo aytadi:\n" +
                                "\"Parvardigoringizni ichingizda yolvorib, qo‘rqib, dildan ertayu-kech yod qiling va g‘ofil kimsalardan bo‘lmang!\"\n" +
                                "(\"A’rof\" surasi, 205-oyat)\n" +
                                "Doniyor qori\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi va kechgi 2":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI VA KECHGI DUO 2";
                        myString[1] =  R.drawable.tongvakechgiduo2 + "";
                        myString[2] =  "Ushbu duoni tongda va kechda 3 martadan aytiladi:";
                        myString[3] =  "اللَّهُمَّ عَافِنِي فِي بَدَنِي ، اللَّهُمَّ عَافِنِي فِي سَمْعِي ، اللَّهُمَّ عَافِنِي فِي بَصَرِي ، لا إِلَهَ إِلا أَنْتَ ،\n" +
                                "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْكُفْرِ وَالْفَقْرِ ، و أَعُوذُ بِكَ مِنْ عَذَابِ الْقَبْرِ ، لا إِلَهَ إِلا أَنْتَ \nَ";
                        myString[4] =  "Abu Dovud va Ahmad rivoyati";
                        myString[5] =  R.raw.tongvakechgi2 + "";
                        myString[6] = "Allohumma, ‘afini fiy badaniy, Allohumma, ‘afini fiy sam’iy, Allohumma, ‘afini fiy basoriy, laa ilaaha illa Anta! Allohumma, inniy a’uuzu bika minal kufri val faqri va a’uuzu bika min ‘azabil qobri laa ilaaha illa Anta";
                        myString[7] = "Allohim, badanimni, qulog‘imni va ko‘zimni (sog‘lom) ofiyatda qil. Allohim, Sening noming ila kufrdan, kambag‘allikdan va qabr azobidan panoh tilayman. Sendan boshqa iloh yo‘q." +
                                "\n" +
                                "\n" +
                                "TONGGI VA KECHKI DUOLARNING SAMARA VA NATIJALARI\n" +
                                "\n" +
                                "Har bir musulmon tonggi va kechki zikr-duolarni doimiy ravishda aytish orqali uning manfaatlaridan bahramand bo‘lishi mumkin. Quyida tonggi va kechki duolarni muntazam takrorlash orqali mo‘min inson erishishi mumkin bo‘lgan samara va natijalarni sanab o‘tamiz:\n" +
                                "\n" +
                                "1. Alloh taoloning rizosiga erishadi.\n" +
                                "2. Shaytonning hiyla-nayranglaridan uzoqlashishiga sabab bo‘ladi.\n" +
                                "3. Yurakdagi g‘am-tashvishlari ariydi.\n" +
                                "4. Jismi va ruhiyatida kuch paydo qiladi. \n" +
                                "5. Allohning zikrida bo‘lish qalb, aql va yuzni nurlantiradi.\n" +
                                "6. Rizq-ro‘z va barakaning kelishiga sabab bo‘ladi.\n" +
                                "7. Musulmon kishi Allohni zikr etish orqali Allohga yaqinlashayotganini va shu orqali qilgan zikrlari ehson darajasiga etib, ya’ni Alloh uni kurib turgandek ibodat qilayotganini sezadi.\n" +
                                "8. Agar musulmon kishi doimiy ravishda Allohning zikrida bo‘lsa, Alloh taolo ham uning o‘zidan ziyodroq eslaydi. Hadiysi Qudusiyda bu haqda shunday deyiladi: \"Alloh taolo aytadi... Meni bir o‘zi eslasa, Men ham uni O‘zim eslayman. Agar u Meni bir jamoa ichida eslasa, Men uni ulardan yaxshiroq jamoa ichida eslayman...\"\n" +
                                "(Buxoriy rivoyati)\n" +
                                "9. Boshqalar tomonidan mo‘min insonga dushmanlik qilib zarar etkazish niyatida qilingan sehr-jodu, yomon amallardan halos bo‘lish uchun qo‘rg‘on bo‘ladi va Allohning hifzu himoyasida ekanini his qilib, huzurlanishi uchun bemorning o‘zi bu duolarni ertayu kech takrorlashi tavsiya qilinadi.\n" +
                                "10. Nazar-nafas va ko‘z tegishidan saqlovchi vosita hisoblanadi.\n" +
                                "11. Mo‘min insonning juz’iy xato va gunohlari kechirilib, uning xayrli va savob ishlari orttiriladi.\n" +
                                "12. Sog‘liqni, inson a’zolarini turli kasalliklardan hamda kufr, kambag‘allik va qabr azobidan panoh topishiga sabab bo‘ladi.\n" +
                                "13. Xuddi hadisi sharifda zikr qilingandek: \"Unga biror narsa zarar bermaydi\".\n" +
                                "\n" +
                                "Alloh taolo aytadi:\n" +
                                "\"Parvardigoringizni ichingizda yolvorib, qo‘rqib, dildan ertayu-kech yod qiling va g‘ofil kimsalardan bo‘lmang!\"\n" +
                                "(\"A’rof\" surasi, 205-oyat)\n" +
                                "Doniyor qori\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tonggi va kechgi 3":{
                        String []myString = new String[8];
                        myString[0] = "TONGGI VA KECHGI DUO 3";
                        myString[1] =  R.drawable.tongvakechgiduo2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam: «Kim tong otganda va kech kirganda:";
                        myString[3] =  "سُبْحَانَ اللهِ وَبِحَمْدِهِ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.tongvakechgi3 + "";
                        myString[6] = "Subhaanallohi va bihamdihi";
                        myString[7] = "Allohga hamd aytish bilan Uni aybu nuqsonlardan poklab yod etaman\n" +
                                "deb 100 marta aytsa, Qiyomat kuni biror kishi undan afzal bo‘la olmaydi. Faqatgina u kabi (100 marta) aytsa yoki undan ziyoda qilsa, afzal bo‘ladi, xolos», dedilar.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qayg‘u-g‘amda o‘qiladigan":{
                        String []myString = new String[8];
                        myString[0] = "QAYG‘U-G‘AMDA O‘QILADI";
                        myString[1] =  R.drawable.qaygugam2 + "";
                        myString[2] =  "Qayg‘u-g‘amda o‘qiladigan duo:";
                        myString[3] =  "اللَّهُ اللَّهُ رَبِّي لَا أُشْرِكُ بِهِ شَيْئًا";
                        myString[4] =  "Abu Dovud va Ibn Moja rivoyati";
                        myString[5] =  R.raw.qaygugam + "";
                        myString[6] = "Allohu, Allohu Robbiy. Laa ushriku bihi shayaa";
                        myString[7] = "Alloh, Alloh Rabbim. Unga biror narsani shirk keltirmayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qayg‘u-g‘amda o‘qiladigan 2":{
                        String []myString = new String[8];
                        myString[0] = "QAYG‘U-G‘AMDA O‘QILADI 2";
                        myString[1] =  R.drawable.qaygugam2 + "";
                        myString[2] =  "Qayg‘u-g‘amda o‘qiladigan duo:";
                        myString[3] =  "لَا إِلَهَ إِلَّا اللَّهُ الْعَظِيمُ الْحَلِيمُ، لَا إِلَهَ إِلَّا اللَّهُ رَبُّ الْعَرْشِ الْعَظِيمِ، لَا إِلَهَ إِلَّا اللَّهُ رَبُّ السَّمَوَاتِ، وَرَبُّ الْأَرْضِ، وَرَبُّ الْعَرْشِ الْكَرِيمِ";
                        myString[4] =  "Buxoriy va Muslim rivoyati";
                        myString[5] =  R.raw.qaygugam2 + "";
                        myString[6] = "Laa ilaaha illallohul ‘azimul haliym Laa ilaaha illallohu Robbul ‘arshil ‘aziym Laa ilaaha illallohu Robbussamavaati va Robbul arzi va Robbul ‘arshil Kariym";
                        myString[7] = "Ulug‘ Halim (mehribon) Allohdan O‘zga iloh yo‘q. Arsh egasi Ulug‘ Allohdan o‘zga xech iloh yo‘q. Osmonlar Rabbisi, er Rabbisi, arsh Rabbisi bo‘lgan Karim Allohdan o‘zga iloh yo‘q.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qayg‘u-g‘amda o‘qiladigan 3":{
                        String []myString = new String[8];
                        myString[0] = "QAYG‘U-G‘AMDA O‘QILADI 3";
                        myString[1] =  R.drawable.qaygugam2 + "";
                        myString[2] =  "Qayg‘u-g‘amda o‘qiladigan duo:";
                        myString[3] =  "لَا إِلَهَ إِلَّا أَنْتَ سُبْحَانَكَ إِنِّي كُنْتُ مِنْ الظَّالِمِينَ";
                        myString[4] =  "Termiziy va Hokim rivoyati";
                        myString[5] =  R.raw.qaygugam3 + "";
                        myString[6] = "Laa ilaaha illa Anta subhaanaka inniy kuntu minazzolimiyn";
                        myString[7] = "Sendan o‘zga hech bir iloh yo‘q. Sen barcha aybu nuqsondan pok Zotdirsan. Darhaqiqat, men (o‘z nafsimga) zulm qiluvchilardan bo‘ldim.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Musibat yetgan kishi duosi":{
                        String []myString = new String[8];
                        myString[0] = "MUSIBAT YETGAN KISHI DUOSI";
                        myString[1] =  R.drawable.musibat2 + "";
                        myString[2] =  "Musibat yetganda quydagicha duo qilish kerak:";
                        myString[3] =  "إِنَّا لِلَّهِ وَإِنَّا إِلَيْهِ رَاجِعُونَ ، اللَّهُمَّ أَجِرْنِي فِي مُصِيبَتِي ، وَأَخْلِفْ لِي خَيْرًا مِنْهَا ";
                        myString[4] =  "Muslim 918";
                        myString[5] =  R.raw.musibat + "";
                        myString[6] = "Innaa lillaahi va Innaa ilayhi roji’uun. Allohumma'jurniy fiy musibati va axlifliy xoyron minhaa";
                        myString[7] = "Albatta, biz Allohnikimiz va albatta, biz Unga qaytuvchimiz, Allohim, menga (bu) musibatimda aju mukofot bergin va uning o‘rniga yaxshirog‘ini bergin.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qarzni to‘lashda o‘qiladi":{
                        String []myString = new String[8];
                        myString[0] = "QARZNI TO‘LASHDA O‘QILADI";
                        myString[1] =  R.drawable.qarzdanqutulish2 + "";
                        myString[2] =  "Qarzni to‘lashda o‘qiladigan duo:";
                        myString[3] =  "اللهُمَّ إِنِّي أَعُوْذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ، وَالْعَجْزِ وَالْكَسَلِ، وَالْبُخْلِ وَالْجُبْنِ، وَضَلَعِ الدَّيْنِ وَغَلَبَةِ الرِّجَالِ";
                        myString[4] =  "Buxoriy rivoyati";
                        myString[5] =  R.raw.qarznitolash + "";
                        myString[6] = "Allohumma inniy a’uuzu bika minal hammi val hazani val ‘ajzi val kasali val buxli val jubni va zola’i-d-dayni va g‘olabatirrijaali";
                        myString[7] = "Allohim! Men Sendan tashvishu g‘amdan, ojizlikdan, yalqovlikdan, baxillikdan, qo‘rqoqlikdan, qarzning og‘irligidan va kishilarning (mening ustimdan) g‘olib bo‘lib ketishidan panoh berishingni so‘rayman. (Rasululloh sollallohu alayhi vasallam bu duoni ko‘p aytar edilar).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qarzni to‘lashda o‘qiladi 2":{
                        String []myString = new String[8];
                        myString[0] = "QARZNI TO‘LASHDA O‘QILADI 2";
                        myString[1] =  R.drawable.qarzdanqutulish2 + "";
                        myString[2] =  "Qarzni to‘lashda o‘qiladigan duo:";
                        myString[3] =  "اللَّهمَّ اكفني بِحلالِكَ عن حرامِكَ ، وأغنِني بِفَضلِكَ عَمن سواكَ ";
                        myString[4] =  "Termiziy rivoyati";
                        myString[5] =  R.raw.qarznitolash2 + "";
                        myString[6] = "Allohumma! Ikfiniy bihalaalika an haromika va ag‘niniy bifazlika amman sivaaka";
                        myString[7] = "Allohim! Menga haloling ila haromingdan kifoya qilgin. O‘z fazling ila meni o‘zingdan boshqalardan behojat qilgin.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qarzni to‘lashda o‘qiladi 3":{
                        String []myString = new String[8];
                        myString[0] = "QARZNI TO‘LASHDA O‘QILADI 3";
                        myString[1] =  R.drawable.qarzdanqutulish2 + "";
                        myString[2] =  "Anas ibn Molik roziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallam Muoz roziyallohu  anhuga: «Senga shunday duo o‘rgatayki, uni o‘qisang garchi Uhud tog‘idek qarzing bo‘lsa ham Alloh qarzingni to‘lashga (shaksiz) yordam beradi». Ey Muoz, ayt:";
                        myString[3] =  "اللَّهُمَّ مالِكَ المُلْكِ تُؤْتِي المُلْكَ مَنْ تَشاءُ، وتَنْزِعُ المُلْكَ مِمَّنْ تَشَاءُ، وتُعِزُّ مَنْ تَشَاءُ، وتُذِلُّ مَنْ تَشاءُ، بِيَدِكَ الخَيْرُ إِنَّكَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ. رَحْمانُ الدُّنْيا والْآخِرَةِ ورَحِيمَهُما، تُعْطِيهُما مَنْ تشاءُ، وتَمْنَعُ مِنْهُما مَنْ تَشاءُ، ارْحَمْنِي رَحْمةً تُغْنِينِي بِها عَنْ رَحْمَةِ مَنْ سِواكَ.";
                        myString[4] =  "Tabaroniy rivoyati";
                        myString[5] =  R.raw.qarznitolash3 + "";
                        myString[6] = "Allohumma maalikal-mulki tu’ til-mulka man tashaau va tanzi’ul-mulka mimman tashaau va tu’izzu man tashaau va tuzillu man tashaau biyadikal-xoyru innaka ‘ala kulli shay’in qodiyr. Rohmaanad-dunya val aaxiroti va Rohiyma humaa tu’tiy humaa man tashaau va tamna’u min humaa man tashaau irhamniy rohmatan tug‘niyniy bihaa ‘an rohmati man sivaaka";
                        myString[7] = "Ey barcha mulkning egasi (bo‘lgan) Allohim! Xohlagan kishingga mulk berursan va xohlagan kishingdan mulkni tortib olursan, xohlagan kishingni aziz qilursan, xohlagan kishingni xor qilursan. Barcha yaxshilik Sening qo‘lingda. Albatta, Sen har bir narsaga qodirsan.\n" +
                                "Ey dunyo va oxiratning Rahmoni va Rohiymi! Sen uni (mol-mulk va martabani) istaganingga berasan, istaganing(dan) mahrum qilasan. Sendan o‘zganing mehr-shafqatiga muhtoj qilmaydigan rahmat ila menga rahm qilgin!\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Ishi og‘irlashganda aytiladi":{
                        String []myString = new String[8];
                        myString[0] = "ISHI OG‘IRLASHGANDA AYTILADI";
                        myString[1] =  R.drawable.ishiogirlashganda2 + "";
                        myString[2] =  "Anas roziyallohu anhudan rivoyat qilinadi. Rasululloh sollallohu alayhi vasallam:";
                        myString[3] =  "اللَّهمَّ لا سَهْلَ إلَّا ما جعلتَه سَهلًا وأنتَ تجعلُ الحزنَ إذا شِئتَ سَهْلًا ";
                        myString[4] =  "Ibn Hibbon rivoyati";
                        myString[5] =  R.raw.ishiogirlashganda + "";
                        myString[6] = "Allohumma laa sahla illa maa ja’altahu sahlan va anta taj’alul hazna iza shi`ta sahla»";
                        myString[7] = "Allohim, Sen engil etgan narsagina engildir. Agar Sen xohlasang, og‘irlik - qattiqlikni ham engil qilguvchisan.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Janoza namozida o‘qiladi":{
                        String []myString = new String[8];
                        myString[0] = "JANOZA NAMOZIDA O‘QILADIGAN DUO";
                        myString[1] =  R.drawable.janozanamozi2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam janoza namozida:";
                        myString[3] =  "اَللّٰهُمَّ اغْفِرْ لِحَيِّنَا وَمَيِّتِنَا وَشَاهِدِنَا وَغَائِبِنَا وَصَغِيْرِنَا وَكَبِيْرِنَا وَذَكَرِنَا وَأُنْثَانَا اَللّٰهُمَّ مَنْ أَحْيَيْتَهُ مِنَّا فَأَحْيِهِ عَلَى الْإِسْلَامِ وَمَنْ تَوَفَّيْتَهُ مِنَّا فَتَوَفَّهُ عَلَى الْإِيْمَانِ";
                        myString[4] =  "Imom Termiziyning rivoyatlarida avval Islom, keyin iymon zikr qilingan. Xuddi ana o‘sha rivoyat Hanafiy mazhabida janoza namozidagi duo etib qabul qilingan.\n" +
                                "Hadis va Hayot – 7 kitob.\n";
                        myString[5] =  R.raw.janoza + "";
                        myString[6] = "Allohummag‘fir lihayyina va mayyitina va shahidina va g‘o'ibina va sog‘iyrina va kabiyrina va zakarina va unsana. Allohumma man ahyaytahu minna faahyihi ‘alal Islam. Va man tavaffaytu minna fatavaffahu ‘alal iyman.";
                        myString[7] = "«Ey Rabbim! Tirigimizni va o‘ligimizni, bu yerda bo‘lganlarni va bo‘lmaganlarni, kichiklarimizni va kattalarimizni, erkak va ayollarimizni kechirgin. Allohim, Bizdan tug‘ilajak yangi nasllarni Islom dinida dunyoga keltir. Ajali yetib hayotdan ko‘z yumadiganlarning jonlarini imonli hollarida olgin».";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Balodan saqlovchi duo":{
                        String []myString = new String[8];
                        myString[0] = "BALODAN SAQLOVCHI DUO";
                        myString[1] =  R.drawable.balodansaqlovchi2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam: «Kimki kasallik (bemorlik, nogironlik yoki majruhlik)ka mubtalo bo‘lgan kishini  ko‘rganda:";
                        myString[3] =  "الْحَمْدُ لله الَّذِي عَافَانِي مِمَّا ابْتَلاَكَ بِهِ وَفَضَّلَنِي عَلَى كَثِيرٍ مِمَّنْ خَلَقَ تَفْضِيلاً";
                        myString[4] =  "Termiziy rivoyati";
                        myString[5] =  R.raw.dua196 + "";
                        myString[6] = "Alhamdu lillahillaziy ‘afaaniy mimmaa ibtalaaka bihi, va faddolaniy ‘alaa kasirin mimman xolaqo tafziyla";
                        myString[7] = "desa, (uning) o‘ziga ana shu balo etmaydi», dedilar.\n" +
                                "\n" +
                                "(Ma’nosi: «Senga sinov uchun berganlaridan meni sog‘-omon saqlagan va yaratganlarining hammasidan afzal qilgan Allohga hamd bo‘lsin»).\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Mehmonning mezbonga duosi":{
                        String []myString = new String[8];
                        myString[0] = "MEHMONNING MEZBONGA DUOSI";
                        myString[1] =  R.drawable.mezbonnimehmonga2 + "";
                        myString[2] =  "Mehmonning mezbonga qiladigan duosi:";
                        myString[3] =  "اللَّهُمَّ بَارِكْ لَهُمْ فِيمَا رَزَقْتَهُمْ، واغْفِرْ لَهُمْ، وارْحَمْهُمْ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.mezbonnimehmonga + "";
                        myString[6] = "Allohumma baarik lahum fiima rozaqtahum vag‘firlahum varhamhum";
                        myString[7] = "Allohim! Ularga bergan rizqingni barakotli qilgin. Ularni (gunohlarini) mag‘firat etgin va ularga rahm qilgin).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qur’oniy duo":{
                        String []myString = new String[8];
                        myString[0] = "QUR’ONIY DUO";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Qur'oniy duo:";
                        myString[3] =  "رَبِّ هَبْ لِي مِن لَّدُنكَ ذُرِّيَّةً طَيِّبَةً ۖ إِنَّكَ سَمِيعُ الدُّعَاءِ ";
                        myString[4] =  "«Oli Imron» surasi, 38-oyat";
                        myString[5] =  R.raw.quroniyduo + "";
                        myString[6] = "Robbi habliy min ladunka zurriyyatan toyyibatan innaka samii’u-d-du’aa'i";
                        myString[7] = "Rabbim, menga (ham) o‘z huzurirgdan pok zurriyot ato et! Darhaqiqat, Sen duoni eshitguvchidirsan.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qur’oniy duo 2":{
                        String []myString = new String[8];
                        myString[0] = "QUR’ONIY DUO";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Qur'oniy duo:";
                        myString[3] =  "رَبَّنَا اغْفِرْ لَنَا وَلِإِخْوَانِنَا الَّذِينَ سَبَقُونَا بِالْإِيمَانِ وَلَا تَجْعَلْ فِي قُلُوبِنَا غِلًّا لِّلَّذِينَ آمَنُوا رَبَّنَا إِنَّكَ رَءُوفٌ رَّحِيمٌ";
                        myString[4] =  "«Hashr» surasi, 10-oyat";
                        myString[5] =  R.raw.quroniyduo2 + "";
                        myString[6] = "Robbanag‘fir lanaa va liixvaaninallaziyna sabaquunaa bi-l-iymaani valaa taj’al fiy quluubinaa g‘illallillaziyna aamanuu Robbanaa innaka Rouufur-rohiym.";
                        myString[7] = "\"Ey Robbimiz, bizlarni va iymonda bizdan ilgari bo‘lgan birodarlarimizni mag‘firat qilgin hamda (barcha) mo‘minlarga nisbatan dilimizda g‘illu-g‘ashlik (paydo) qilmagin. Ey Robbimiz, Sen albatta Rauff(o‘ta mehribon va shafqatli) va Rohiym(Qiyomat kuni faqat mo‘minlarga rahim qiluvchi) dursan\".";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qur’oniy duo 3":{
                        String []myString = new String[8];
                        myString[0] = "QUR’ONIY DUO";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Qur'oniy duo:";
                        myString[3] =  "رَبَّنَا لَا تُزِغْ قُلُوبَنَا بَعْدَ إِذْ هَدَيْتَنَا وَهَبْ لَنَا مِن لَّدُنكَ رَحْمَةً ۚ إِنَّكَ أَنتَ الْوَهَّابُ ";
                        myString[4] =  "«Oli Imron» surasi, 8-oyat";
                        myString[5] =  R.raw.quroniyduo3 + "";
                        myString[6] = "Robbanaa laa tuzig‘ quluubanaa ba’da iz hadaytanaa va hablanaa min ladunka rohmatan, innaka anta-l-vahhaab.";
                        myString[7] = "«Ey Robbimiz, bizni hidoyat qilganingdan so‘ng qalblarimizni og‘dirmagin va bizga O‘z huzuringdan rahmat ato qilgin. Albatta Sening O‘zing ko‘plab ato qiluvchisan».";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qur’oniy duo 4":{
                        String []myString = new String[8];
                        myString[0] = "QUR’ONIY DUO";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Azizlar, bir duoning o‘zida Alloh taolodan ham o‘zingizni, ham ota-onangizni, va barcha mo‘minlarning gunohlarini mag‘firat qilishini (kechirishini) so‘ramoqchi bo‘lsangiz, ushbu Qur’oniy duoni o‘qib yuring:";
                        myString[3] =  "رَبَّنَا اغْفِرْ لِي وَلِوَالِدَيَّ \n" +
                                "وَلِلْمُؤْمِنِينَ يَوْمَ يَقُومُ الْحِسَابُ\n";
                        myString[4] =  "«Ibrohim» surasi, 41-oyat.";
                        myString[5] =  R.raw.quroniyduo4 + "";
                        myString[6] = "Robbanag‘firliy va livaalidayya va lilmu‘miniina yavma yaquumu-l-hisaab.";
                        myString[7] = "\"Ey, Rabbimiz! Hisob-kitob qilinadigan (qiyomat) kuni meni, ota-onamni va (barcha) mo‘minlarni mag‘firat qilgin!\".";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Sunnatda kelgan duo":{
                        String []myString = new String[8];
                        myString[0] = "QALBNI TOATGA BURISH DUOSI ";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "ALLOHIM, QALBIMIZNI TOATINGGA BURIB QO‘YGIN!\n" +
                                "\n" +
                                "Musulmonlik bir qarashda oson va bir qarashda og‘ir vazifadir. Osonligi shundaki, \"Laa ilaaha illalloh, Muhammadun Rasululloh\" desangiz, bas, siz musulmon sanalasiz. Og‘irligi shundaki, aslida, musulmonlik har bir daqiqa umrni ibodat bilan, ya’ni Alloh taolo buyurganidek o‘tkazish demakdir. Har doim Alloh taoloni eslab, o‘z-o‘zini nazorat qilib yurish, demakdir. \n" +
                                "Ko‘pchilik musulmonlar besh vaqt namoz, yilda bir oy ro‘za va qodir bo‘lganda hajj qilish musulmonmonlik uchun kifoya, deb biladilar. \n" +
                                "Yo‘q, musulmon bir kunda yigirma to‘rt soat ibodatda, ya’ni Alloh taolo buyurganidek holatda bo‘lishi lozim. \n" +
                                "Har daqiqada Alloh taoloni zikr qilib, ya’ni eslab turish, har bir qilayotgan ishida o‘zining musulmon ekanini esdan chiqarmay, musulmonlikka loyiq ish qilish, \"shu ishim iymonimga zid emasmikan?\"  deb ehtiyot bo‘lish ayni ibodatdir. \n" +
                                "Bunday bo‘lish qiyin-ku, deydiganlarga judayam oson bir duoni eslatib qo‘ymoqchimiz.\n" +
                                "\n" +
                                "Abdulloh ibn Amr ibn Oss roziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallam \n";
                        myString[3] =  "اللَّهُمَّ مُصَرِّفَ القُلُوبِ صَرِّفْ قُلُوبَنَا عَلَى طَاعَتِكَ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.sunnatda_kelgan_duo + "";
                        myString[6] = "Allohumma musorrifal quluub sorrif quluubana ‘alaa to’atik";
                        myString[7] = "deb aytardilar. \n" +
                                "\n" +
                                "Ma’nosi: Ey qalblarni tasarruf qiluvchi Allohim, qalbimizni toatingga burib qo‘ygin.\n" +
                                "\n" +
                                "Mana shu duoni ixlos bilan aytib yurgan har bir mo‘min-musulmonning  haqiqiy solih insonlardan bo‘lishiga Alloh taoloning O‘zi yordam beradi, inshaalloh!\n" +
                                "Ya’ni, shu duoni ixlos bilan o‘qib yurgan odam ibodatlarga  hech erinmaydigan, nafl ibodatlarni ham sevib bajaradigan, umrining har bir daqiqasini ibodat bilan o‘tkazishga harakat qiladigan bo‘lib qoladi, inshaalloh!\n" +
                                "Aslida, musulmonlikning mohiyati ham shunda.\n" +
                                "\n" +
                                "Shahobiddin Odilov, \n" +
                                "Doniyor Fayz\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Sunnatda kelgan duo 2":{
                        String []myString = new String[8];
                        myString[0] = "SUNNATDA KELGAN DUO";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Sunnatda kelgan duo:\n";
                        myString[3] =  "اللهُمَّ إِنِّي أَسْأَلُكَ الْعَافِيَةَ فِي الدُّنْيَا وَالْآخِرَةِ..";
                        myString[4] =  "Buxoriy rivoyati";
                        myString[5] =  R.raw.sunnatda_kelgan_duo2 + "";
                        myString[6] = "Allohumma inniy as'aluka-l-’aafiyata fi-d-dunyaa va-l-aaxiroti";
                        myString[7] = "Allohim, Sendan dunyo va oxiratda ofiyat (omonlik) so‘rayman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Sunnatda kelgan duo 3":{
                        String []myString = new String[8];
                        myString[0] = "DUO HAM SHIFODIR";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Sunnatda kelgan duo:\n";
                        myString[3] =  "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْبَرَصِ وَالْجُنُونِ وَالْجُذَامِ وَمِنْ سَيِّئْ الْأَسْقَامِ ";
                        myString[4] =  "Abu Dovud, Ahmad va Nasoiy rivoyati";
                        myString[5] =  R.raw.sunnatda_kelgan_duo3 + "";
                        myString[6] = "Allohumma inniy a’uuzu bika mina-l-barosi va-l-junuuni va-l-juzaami va min sayyi’i-l-asqomi";
                        myString[7] = "\"Allohim, Sendan moxovlik, peslik, jinnilik va (barcha) yomon kasalliklardan panoh so‘rayman\".";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Panoh so‘rash duosi":{
                        String []myString = new String[8];
                        myString[0] = "PANOH SO‘RASH DUOSI";
                        myString[1] =  R.drawable.quroniyduo2 + "";
                        myString[2] =  "Sunnatda kelgan duo:\n";
                        myString[3] =  "اللَّهُمَّ إنِّي أعُوذُ بِكَ مِنَ العَجْزِ، والكَسَلِ، والجُبْنِ، والبُخْلِ، والهَرَمِ، والقَسْوَةِ، والغَفْلَةِ، والعَيْلَةِ، والذِّلَّةِ، والمَسْكَنَةِ، وأعُوذُ بِكَ مِنَ الفَقْرِ، والكُفْرِ، والفُسُوقِ، والشِّقاقِ، والنِّفاقِ، والسُّمْعَةِ، والرِّياءِ، وأعُوذُ بِكَ مِنَ الصَّمَمِ، والبَكَمِ، والجُنُونِ، والجُذامِ، والبَرَصِ، وَسَيِّىءِ الأَسْقامِ";
                        myString[4] =  "Hokim va Bayhaqiy rivoyati";
                        myString[5] =  R.raw.panoh_sorash_duosi + "";
                        myString[6] = "Allohumma inniy a’uuzu bika mina-l-’ajzi va-l-kasali va-l-jubni va-l-buxli va-l-haromi va-l-qosvati va-l-g‘oflati va-l-’aylati va-z-zillati va-l-maskanati va a’uuzu bika mina-l-faqri va-l-kufri va-l-fusuuqi va-sh-shiqooqi va-n-nifaaqi va-s-sum’ati va-r-riyaa'i va a’uuzu bika mina-s-somami va-l-bakami va-l-junuuni va-l-juzaami va-l-barosi va sayyi'i-l-asqoomi.";
                        myString[7] = "\"Allohim! Men Sendan ojizlikdan, yalqovlikdan, qo‘rqoqlikdan, baxillikdan, qarigandigi ojizlikdan, toshbag‘irlikdan, g‘aflatdan, faqirlikdan, xorlikdan va miskinlikdan panoh so‘rayman va kambag‘allikdan, kufrdan, fosiqlikdan , badbaxtlikdan, munofiqlikdan, sum’a (odamlar eshitsin uchun amal qilish)dan va riyo(xo‘jako‘rsin)dan panoh berishingni so‘rayman, hamda, karlikdan, soqovlikdan, jinnilikdan, pes-mohovlikdan va boshqa yomon kasallikdan ham panoh berishingni so‘rayman\".";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Shar’iy qo‘shilish duosi":{
                        String []myString = new String[8];
                        myString[0] = "SHAR’IY QO‘SHILISH DUOSI";
                        myString[1] =  R.drawable.qoshilishdanoldin2 + "";
                        myString[2] =  "Ibn Abbos roziyallohu anhudan rivoyat qilinadi: «Nabiy sollallohu alayhi vasallam: «Agar birortangiz o‘z jufti haloli bilan qo‘shilmoqchi bo‘lsa:\n";
                        myString[3] =  "بِسْمِ اللهِ، اللَّهُمَّ جَنِّبْنَا الشَّيْطَانَ وَجَنِّبِ الشَّيْطَانَ مَا رَزَقْتَنَا";
                        myString[4] =  "Buxoriy 141va Muslim 1434";
                        myString[5] =  R.raw.qoshilishdanoldin + "";
                        myString[6] = "Bismillahi, Allohumma! Jannibnash-shaytona va jannibish-shaytona maa rozaqtanaa";
                        myString[7] = "«Allohning nomi bilan. Allohim, bizdan shaytonni yiroq qilgin, shaytonni bizni rizqlantirgan narsang (farzand)dan chetda qilgin».\n" +
                                "\n" +
                                "Desa, albatta, agar bundan ularga farzand taqdir qilingan bo‘lsa, unga shayton hech qachon zarar etkaza olmaydi, dedilar.\n" +
                                "\uD83D\uDD30Ushbu hadisdagi duo sharhida ulamolar quyidagi foydalarni eslatib o‘tadilar:\n" +
                                "\uD83C\uDF3F Alloh nomi bilan boshlanadigan barcha ishlarda baraka bo‘lur. \n" +
                                "\uD83C\uDF3F Agar ushbu duodan so‘ng Alloh taolo insonlarni farzand bilan rizqlantirsa, shu duo orqali go‘daklari shaytonning yomonligidan panoh topadi. \n" +
                                "\uD83C\uDF3F Shu duo sabab shayton bu bola ustidan hukmronlik qila olmaydi. \n" +
                                "\uD83C\uDF3F Bu duo yordamida bola turli ruhiy kasalliklardan panoh topadi. \n" +
                                "\uD83C\uDF3F Yana, chaqaloq tug‘ilganda badanida uchrashi mumkin bo‘lgan turli nuqsonlar yoki jin tegishidan mazkur duoning barakotidan forig‘ bo‘ladi. \n" +
                                "\uD83C\uDF3F Umri yakunida bu bola tavhidda – iymon kalimasi bilan dunyodan o‘tishiga sabab bo‘ladi.\n" +
                                "\n" +
                                "✅Farzand kutayotgan yosh ota-onalarga tug‘ilajak farzandlari uchun eng maqbul islomiy ismlar tanlash borasida xolis maslahatlar: \n" +
                                "\uD83D\uDE4D\uD83C\uDFFB\u200D♂️Agar oilangizda o‘g‘il farzand tug‘ilsa, avvalo hadislarda keltirilgan va Alloh taologa eng suyumli bo‘lgan Abdulloh va Abdurahmon ismlaridan birini tanlang.\n" +
                                "Shuningdek, Ibrohim, Yusuf, Ayyub, Yunus, Yahyo, Ahmad, Muhammadamin, Abu Bakr, Umar, Usmon, Ali kabi ismlarni tanlash ham ota-onalar uchun katta ajru mukofotlar berilishiga sabab bo‘ladi.\n" +
                                "Faqat shu ismlar bilan cheklanmay, o‘zbek yigitlaridagi shijoat, mardlik va birso‘zlikni ifodalovchi ismlarni qo‘yish  ham tavsiya qilinadi.\n" +
                                "\n" +
                                "\uD83D\uDE4D\uD83C\uDFFBAgar oilangizda qiz farzand tug‘ilsa, avvalo hadislarda keltirilgan va Nabiy alayhissalom eng afzal jannatiy ayollar deb bashorat qilgan Hadicha, Fotima, Maryam, Osiyo ismlaridan birini tanlang. \n" +
                                "Shuningdek, qizlar uchun Oisha, Zaynab, Safiya, Asmo, Hanifa, Fazilat va Muslima kabi ismlarni tanlash ham ism egalari uchun foydadan xoli bo‘lmaydi.\n" +
                                "Shu bilan birga, millatimizga va o‘zbek qizlariga xos andisha, ibo-hayoni ifodalovchi ma’noli ismlar qo‘yish ham mumkin.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tahorat olishdan avval":{
                        String []myString = new String[8];
                        myString[0] = "TAHORAT OLISHDAN AVVAL";
                        myString[1] =  R.drawable.tahoratolish2 + "";
                        myString[2] =  "Tahorat olishdan avval o‘qiladigan duo:";
                        myString[3] =  "ِسْمِ الله";
                        myString[4] =  "Abu Dovud (101), ibnu Mojar (397), Axmad (9418).";
                        myString[5] =  R.raw.bismillah + "";
                        myString[6] = "Bismillah";
                        myString[7] = "Bismillah (Ollohning ismi bilan boshlayman yoki tahorat qilaman).";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tahorat olib bo‘lgach":{
                        String []myString = new String[8];
                        myString[0] = "TAHORATDAN SO‘NG AYTILADI";
                        myString[1] =  R.drawable.taxoratdansong2 + "";
                        myString[2] =  "Tahoratdan so‘ng aytiladigan duo:";
                        myString[3] =  "اللَّهُمَّ اجْعَلْنِي مِنْ التَّوَّابِينَ ، وَاجْعَلْنِي مِنْ الْمُتَطَهِّرِينَ ";
                        myString[4] =  "At-Tirmizi (55), «Saxixut-Tirmizi» (1/18)";
                        myString[5] =  R.raw.tahoratdansong + "";
                        myString[6] = "Allohummaj’alniy minattavvabiyna va ja’alniy minal mutatohhiriyna";
                        myString[7] = "Allohim! Meni tavba qiluvchilardan va tahoratli-pokiza kishilardan qilgin.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tahorat olib bo‘lgach 2":{
                        String []myString = new String[8];
                        myString[0] = "TAHORATDAN SO‘NG AYTILADI 2";
                        myString[1] =  R.drawable.taxoratdansong2 + "";
                        myString[2] =  "Umar roziyallohu anhudan rivoyat qilinadi: «Payg‘ambar sollallohu alayhi vasallam: «Agar sizlardan birortangiz tahorat olsa-yu, tahoaratini yaxshilab qilsa, so‘ngra tahoratidan forig‘ bo‘lishida:";
                        myString[3] =  "أَشْهَدُ أَنْ لا إِلَهَ إِلا اللَّهُ وَحْدَهُ لا شَرِيكَ لَهُ ، وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ ،";
                        myString[4] =  "Muslim (234)";
                        myString[5] =  R.raw.tahoratdansong2 + "";
                        myString[6] = "Ashhadu allaa ilaaha illallohu vahdahu laa shariyka lahu. Va ashhadu anna Muhammadan abduhu va rosuluhu";
                        myString[7] = "deb aytsa, albatta, unga jannatning sakkiz eshigi ochilur va u xohlaganidan kirur», – dedilar».";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tahorat olib bo‘lgach 3":{
                        String []myString = new String[8];
                        myString[0] = "TAHORATDAN SO‘NG AYTILADI 3";
                        myString[1] =  R.drawable.taxoratdansong2 + "";
                        myString[2] =  "Tahoratdan so‘ng aytiladigan duo:";
                        myString[3] =  "سُبْحانَكَ اللَّهُمَّ وَبِحَمْدِكَ، أَشْهَدُ أَنْ لاَ إِلَهَ إِلاَّ أَنْتَ، أَسْتَغْفِرُكَ وَأَتوبُ إِلَيْكَ";
                        myString[4] =  "An-Nasai «‘Amalyul’-Vaumi yal’-Leylya» (173, 81-raqam),  «Irvaul’-G’alil’» (1/135, 3/94)";
                        myString[5] =  R.raw.dua15 + "";
                        myString[6] = "Subhanakallohumma va bihamdika, Ashhadualla ilaha illallohu illa anta, astag’firuka va atubu ilayka";
                        myString[7] = "Ey Olloh! Sen aybu nuqsondan pokdirsan, barcha maqtovlar Sengadir. Guvohlik beramanki, Sendan o‘zga iloh yo‘qdir. Senga istig‘for aytib, tavba qilaman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Ot-ulovga minilganda":{
                        String []myString = new String[8];
                        myString[0] = "OT-ULOV (MASHINA)GA MINILGANDA";
                        myString[1] =  R.drawable.transportga2 + "";
                        myString[2] =  "Ot-ulov (mashina, samolyot, kema)ga minilganda o‘qiladigan duo:";
                        myString[3] =  "(بسم الله، الحمد لله)  \n" +
                                "سُبْحَانَ الَّذِي سَخَّرَ لَنَا هَٰذَا وَمَا كُنَّا لَهُ مُقْرِنِينَ\n" +
                                "\u200Eوَإِنَّا إِلَىٰ رَبِّنَا لَمُنقَلِبُونَ\n";
                        myString[4] =  "«Zuxruf» 13-14 oyatlar";
                        myString[5] =  R.raw.transportga + "";
                        myString[6] = "(Bismillahi, alhamdulillahi)\n" +
                                "Subhanallaziy saxxora lanaa haaza va maa kunna lahu muqriniyn va innaa ilaa Robbina lamunqolibuun\n";
                        myString[7] = "(Alloh nomi bilan, Allohga hamd bo‘lsin).\n" +
                                "Bizga buni bo‘ysundirgan zot pokdir. Biz bunga qodir emas edik. Va, albatta, Biz Robbimizga qaytguvchidirmiz.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Ot-ulovga minilganda 2":{
                        String []myString = new String[8];
                        myString[0] = "OT-ULOV (MASHINA)GA MINILGANDA";
                        myString[1] =  R.drawable.transportga2 + "";
                        myString[2] =  "Ot-ulov (mashina, samolyot, kema)ga minilganda o‘qiladigan duo:";
                        myString[3] =  "بِسْمِ اللَّهِ، وَالْحَمْدُ للَّهِ";
                        myString[4] =  "Abu Dovud 2602, Termiziy 3446";
                        myString[5] =  R.raw.dua210 + "";
                        myString[6] = "Bismillahi valhamdulillah";
                        myString[7] = "Alloh taologa hamdlar bo'lsin!";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Safarga chiqishdagi duo":{
                        String []myString = new String[8];
                        myString[0] = "SAFARGA CHIQISHNI NIYATI";
                        myString[1] =  R.drawable.safarga_chiqqanda + "";
                        myString[2] =  "Abdulloh ibn Umar roziyallohu anhumodan rivoyat qilinadi:\n" +
                                "«Rasululloh sollallohu alayhi vasallam safarga chiqadigan bo‘lsalar, ulovlariga o‘rnashib olganlaridan keyin uch marta takbir aytar, so‘ngra:";
                        myString[3] =  "سبْحانَ الذي سخَّرَ لَنَا هذا وما كنَّا له مُقرنينَ، وَإِنَّا إِلى ربِّنَا لمُنقَلِبُونَ . اللَّهُمَّ إِنَّا نَسْأَلُكَ في سَفَرِنَا هذا البرَّ والتَّقوى ، ومِنَ العَمَلِ ما تَرْضى . اللَّهُمَّ هَوِّنْ علَيْنا سفَرَنَا هذا وَاطْوِ عنَّا بُعْدَهُ ، اللَّهُمَّ أَنتَ الصَّاحِبُ في السَّفَرِ ، وَالخَلِيفَةُ في الأهْلِ. اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ وعْثَاءِ السَّفَرِ ، وكآبةِ المنظَرِ ، وَسُوءِ المنْقلَبِ في المالِ والأهلِ وَالوَلدِ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.safarga_chiqqanda + "";
                        myString[6] = "«Subhanallaziy saxxoro lana haza va ma kunna lahu muqriniyn va inna ila robbina lamunqolibun. Allohumma inna nas'aluka fiy safarina haza al-birro vattaqva va minal ‘amali ma tarzo, Allohumma havvin ‘alayna safarona haza vatvi ‘anna bu’dahu, Allohumma antas sohibu fissafari valxoliyfatu fil ahli. Allohumma inniy a’uzu bika min va’sai safari va kaabatil manzori va su'il munqolabi fil mali val ahli val valadi», deb aytardilar.";
                        myString[7] = "«Bizlarga bu (kema yoki ot- ulov)ni bo‘ysundirib qo‘ygan Zot (ya’ni, Alloh barcha aybu nuqsondan) pokdir. Biz o‘zimiz bunga qodir emas edik. Shak- shubhasiz, bizlar (barchamiz) Rabbimizga\n" +
                                "qaytguvchidirmiz. Allohim, Sendan bu safarimizda yaxshilik va taqvoni hamda Sen rozi bo‘ladigan amalni so‘raymiz. Allohim, bu safarimizni bizga engil qilib, uzoqligini yaqin qilgin. Allohim, safardagi yo‘ldosh ham, xonadonda qoluvchi o‘rinbosar ham Uzingdirsan. Allohim, men Sendan safar mashaqqatlaridan, mahzunlik manzarasi va molu-mulk, oilaga va farzandlarga etadigan ziyon- zahmatdan panoh berishingni so‘rayman»\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Safardan qaytgandagi zikr":{
                        String []myString = new String[8];
                        myString[0] = "SAFARDAN QAYTGANDAGI ZIKR";
                        myString[1] =  R.drawable.safardan_qaytganda + "";
                        myString[2] =  "Agar (Nabiy sollallohu alayhi vasallam) safardan qaytsalar, yuqoridagi duoni aytib, quyidagilarni qo‘shimcha qilardilar:";
                        myString[3] =  "آيِبونَ تَائِبونَ عَابِدُون لِرَبِّنَا حَامِدُونَ ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.safardan_qaytganda + "";
                        myString[6] = "«Aayibuna, taaibuna, ‘abiduna, lirobbina haamiduna";
                        myString[7] = "«(Biz) qaytuvchi, tavba qiluvchi, ibodat qiluvchi va Rabbimizga hamd aytuvchilarmiz».";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yomg‘ir yog‘ayotganda":{
                        String []myString = new String[8];
                        myString[0] = "YOMG‘IR YOG‘AYOTGANDA";
                        myString[1] =  R.drawable.yomgiryogganda2 + "";
                        myString[2] =  "Oisha roziyallohu anhodan rivoyat qilinadi: «Nabiy sollallohu alayhi vasallam: «...Agar yomg‘ir yog‘sa:";
                        myString[3] =  "اللَّهمَّ صَيِّبًا نافِعًا ";
                        myString[4] =  "Al’-Buxori ma’al’-Fatx 2/518 raqami:1032";
                        myString[5] =  R.raw.dua172+ "";
                        myString[6] = "Allohumma soyyiban naafi’an";
                        myString[7] = "Allohim! Foydali va nafli qilgin», der edilar";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Bemorga o‘qiladigan duo":{
                        String []myString = new String[8];
                        myString[0] = "BEMORGA O‘QILADIGAN DUO";
                        myString[1] =  R.drawable.kasalkorish2 + "";
                        myString[2] =  "Ibn Abbos roziyallohu anhudan rivoyat qilinadi. Rasululloh sollallohu alayhi vasallam:  «Kim kasal ko‘rgani borganida, agar ajali etmagan bo‘lsa, uning huzurida etti marta:";
                        myString[3] =  "أَسْأَلُ اللهَ الْعَظِيمَ رَبَّ العَرْشِ العَظِيمِ أَنْ يَشْفِيَكَ";
                        myString[4] =  "Abu Dovud 3106 va Termiziy 2083";
                        myString[5] =  R.raw.kasalkorish+ "";
                        myString[6] = "As`alullohal ‘aziyma Robbal ‘arshil ‘aziymi an yashfiyaka» -desa, Alloh taolo uni kasalidan xalos qiladi»,  dedilar.";
                        myString[7] = "Ulug‘ Allohdan, buyuk arsh Rabbidan senga shifo berishini so‘rayman" +
                                "\n" +
                                "\n" +
                                "BEMORLIK NIMA: AZOB - UQUBATMI YOKI SINOV?\n" +
                                "\n" +
                                "Inson borki hayoti davomida biror kasallikni boshidan kechiradi. Albatta, inson o‘z hayotining birdek ravon, musibatlarsiz o‘tishini xohlaydi. Ammo, «issiq jon» deganlaridek, kasallik turli insonlarda og‘ir yoki engil kechishi mumkin. Inson jisman dard chekar ekan, uning ruhiyatida ham albatta salbiy fikrlar kechadi. Bu ruhiy kechinmalar insonning yoshiga ham bog‘liq bo‘ladi. Inson yoshlikda kasallikni oson o‘tkazish bilan birga, u bu haqda chuqur o‘ylamaydi ham. Ammo yoshi o‘tgan sari kasallik unga guyoki doimiy hamrohdek tuyulib, hali u eri, hali bu eri og‘rishidan noliy boshlaydi. Hatto yomon hayollarga borib besabrlik qiladi va buni go‘yo Alloh taoloning g‘azabiga uchraganlik belgisi deb tushunadi. Aslida ham shundaymi? Zotan, har bir inson hayoti davomida turli qiyinchilik va musibatlarga duch keladi. Chunki hayotning o‘zi sinov va imtihonlardan iborat. Vaholanki, dard kelganda ba’zi insonlarning umidsizlikka tushib zaiflashib qolishlari ularning kasallik orqasidan keladigan hikmatlardan bexabar ekanliklarining alomatidir. Mo‘min musulmonga Alloh taolo tomonidan yuboriladigan barcha kasalliklar u uchun xayrlidir. Goho bandalar farz qilingan ibodatlarni to‘liq ado eta olmasliklari yoki solih amallari etarli bo‘lmasligi mumkin. Bunday holatda Alloh taolo ularga biror kasallik yoki musibat yuborib, O‘z huzurida ularning gunohlarini kechib, ulug‘ darajalarga ko‘taradi. Ushbu so‘zimizga quyidagi hadis dalil bo‘la oladi. Muhammad ibn Xolid as-Sulamiyning bobosidan qilingan rivoyatda: «Nabiy sollallohu alayhi vasallam: «Albatta, Allohdan bir bandaga martaba yozilgan bo‘lsa-yu, banda amali bilan unga etmagan bo‘lsa, Alloh uni jasadida yoki molida, yoki bolasida balo (musibat)ga giriftor qiladi. So‘ngra uni ana shunga, toki Allohdan uning uchun yozilgan martabaga erishtirguncha sabr qildiradi», – dedilar» \n" +
                                "(Abu Dovud rivoyati).\n" +
                                "\n" +
                                "Agar Alloh taolo dard va alamlarni yubormaganida edi, insonlar sog‘likning qadriga etmagan bo‘lar edilar. Ba’zida inson kasallik, g‘am-tashvish va faqirlik kabi musibatlar unga Alloh tamonidan yuborilgan ne’mat ekanligini anglab etishi zarur. Agar teranroq o‘ylab ko‘rsak, bu musibatlar bilib-bilmay qilgan gunohlarimiz uchun kafforat bo‘lishini tushunamiz. Diniy manbalardan ma’lumki, solih kishilar turli musibatlarga uchrab turishi YAratganning unga muhabbati alomatidir. Jumladan, kasallikning kelishi Alloh taoloning unga yaxshilikni iroda kilgani belgisidir. Bunday kishilar uchun musibat va kasalliklar Alloh taolo oldida ularning darajotlari ko‘tarilishiga vositadir. Bu fikrimizga Abu Hurayra roziyallohu anhudan rivoyat qilingan ushbu hadisi sharif misol bo‘la oladi. Rasululloh sollallohu alayhi vasallam: «Alloh kimga yaxshilikni xohlasa, uni biror musibatga mubtalo qiladi», – dedilar. \n" +
                                "(Buxoriy rivoyati).\n" +
                                "\n" +
                                "Dinimiz tarixiga nazar solsak ham yuqoridagi fikrlarimizni tasdiqlovchi misollarni keltirish mumkin. Ayrim payg‘ambarlarni ham bunday musibatlar chetlab o‘tmagan. Hattoki bashariyat sayyidi bo‘lmish Muhammad alayhissalom ham bemor bo‘lganlar. Ibn Mas’ud roziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallamning huzurlariga kirsam, u zot isitmalab yotgan ekanlar. Men: «Ey Allohning rasuli, siz qattiq isitmalayapsiz-a?» – desam, u zot: «Ha, men sizlardan ikki kishi isitmalagani kabi isitma bo‘laman», – dedilar. «Unda sizga ikki ajr bo‘ladimi?» – desam, «Ha, shu singari biror musulmonga aziyat etsa, tikonmi yoki undan kattarog‘i azob bersa, u bilan yomonliklari o‘chirilib, gunohlari xuddi daraxt bargidek to‘kilib ketadi», – dedilar»\n" +
                                "(Buxoriy va Muslim rivoyati).\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "BEMORNI ZIYORAT QILISh FAZILATI\n" +
                                "\n" +
                                "Kasallikning hikmatlari bilan birga, shu o‘rinda bemorlarni ziyorat qilish fazilatlari haqida ham tuxtalsak. Ushbu hadisi qudsiy bu fikrimizni yorqin ifodalab beradi. Abu Hurayra roziyallohu anhudan rivoyat qilinadi. Rasululloh sollallohu alayhi vasallam dedilar: «Alloh taolo Qiyomat kuni: «Ey odam bolasi, kasal bo‘ldim, meni ko‘rgani bormading», deydi. Shunda u kishi: «Ey Rabbim, qanday qilib seni ko‘rgani boraman? Sen olamlarning Rabbi bo‘lsang», deydi. Alloh esa: «Bilmaysanmi, falonchi bandam kasal bo‘ldi, lekin uni ko‘rgani bormading. Agar uni ko‘rgani borganingda uning huzurida meni topar eding», deydi. Alloh: «Ey odam bolasi, sendan ovqat so‘radim, menga uni bermading», desa, u kishi: «Ey Rabbim, qanday qilib seni ovqatlantiraman? Sen olamlar Rabbi bo‘lsang», deydi. Alloh esa: «Bilmaysanmi, falonchi bandam sendan ovqat so‘radi, lekin sen unga taom bermading. Agar unga ovqat berganingda huzurimdan uni topar eding», deydi. Alloh: «Ey odam bolasi, sendan suv talab qildim. Lekin meni suv bilan siylamading», desa, u kishi: «Ey Rabbim, nechuk seni suv ila siylayman? Vaholanki, sen olamlar Rabbi bo‘lsang», deydi. Alloh esa: «Falonchi bandam suv talab qildi. Sen unga suv bermading. Bilmaysanmiki, agar suv bilan siylaganingda, uni mening huzurimdan topar eding», deydi»\n" +
                                "(Muslim rivoyati).\n" +
                                "\n" +
                                "Ushbu hadisda e’tibor qaratishimiz lozim bo‘lgan alohida ta’kidlangan nozik bir lafz bor. Mazkur hadisdagi: «Agar unga ovqat berganingda huzurimdan uni (ajr-mukofotini) topar eding yoki «suv bilan siylaganingda, uni mening huzurimdan topar eding», lafzidan ko‘ra «Bilmaysanmi, falonchi bandam kasal bo‘ldi, lekin uni ko‘rgani bormading. Agar uni ko‘rgani borganingda uning huzurida meni topar eding», lafzi bo‘rttirib ko‘rsatilgani bejiz emas. Bu bilan bemor huzuriga ziyorat uchun borgan inson albatta Alloh taoloning rahmati va mag‘firatiga erishishi bashorat qilinmoqda. Shuningdek, Alloh taoloning boshqa bandalariga nisbatan xasta va bemorlarga ma’naviy yaqinligiga ishora qilinmoqda. E’tibor bering, bu erda: «uning huzurida meni topar eding» deyilishi bilan xasta va bemor kishilarga alohida e’tibor ko‘rsatish, ularning ko‘ngilini ko‘tarish, dil yaralariga malham bo‘lish kabi insoniy fazilatlar ulug‘lanmoqda. \n" +
                                "\n" +
                                "Demak, gap bemorni ziyorat qilish fazilatlari haqida ketar ekan, ziyorat qilish uchun borgan kishining bemor huzurida unga umid baxsh etadigan, ruhiyatini ko‘taradigan so‘zlar bilan siylash aynan sunnatga muvofiq ishlardan sanaladi. Bu borada Imom Buxoriy rivoyat qilishicha, Payg‘ambarimiz sollallohu alayhi vasallam bemorni ziyorat qilsalar: “Laa ba’sa, tohurun inshaalloh”, ya’ni «Zarari yo‘q, inshaalloh, (bu kasallik sizni), gunohlardan poklaydi», – deb aytardilar.\n" +
                                "Doniyor Fayz\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Bemor uchun shifo topishning bir necha sabablari bor\n" +
                                "\n" +
                                "Bemor inson o‘ning dardiga Alloh shifo berishidan umidvor bo‘lishi bilan birga, dardining davosi uchun sabab bo‘ladigan turli vositalar haqida o‘ylashi ham tabiiydir. Darhaqiqat, Imom Buxoriy Abu Hurayra roziyallohu anhudan rivoyat qilgan hadisi sharifda: «Nabiy sollallohu alayhi vasallam: «Alloh qaysi bir dardni nozil qilgan bo‘lsa, albatta, uning shifosini ham tushirgandir», dedilar». Shunday ekan, bemor shifo vositasi sifatida tabiblarga murojaat qilishi, tibbiy muolajalardan foydalanishi o‘rinlidir. Ushbu vositalardan yana biri duodir. Chin ixlos bilan o‘zi va boshqalar tomonidan qilingan duolar orqali ham davo topish mumkin. \n" +
                                "Xususan, Nabiy alayhissalomdan keltirilgan hadislarda aytilganidek, har bir dardga shifo bo‘luvchi duolardan o‘qib yurish ham tavsiya qilinadi. Jumladan, Ibn Abbos roziyallohu anhudan rivoyat qilingan hadisda Rasululloh sollallohu alayhi vasallam: «Kim kasal ko‘rgani borganida, agar ajali etmagan bo‘lsa, uning huzurida etti marta: «As`alullohal ‘aziyma Robbal ‘arshil ‘aziymi an yashfiyaka», – desa, Alloh taolo uni kasalidan xalos qiladi», dedilar. \n" +
                                "(Ma’nosi: Ulug‘ Allohdan, buyuk arsh Rabbidan senga shifo berishini so‘rayman.) \n" +
                                "(Abu Dovud va Termiziy rivoyati). \n" +
                                "Shu kabi tongda va kechda uch martadan aytiladigan ushbu duo: «Allohumma, ‘afini fiy badaniy, Allohumma, ‘afini fiy sam’iy, Allohumma, ‘afini fiy basoriy, laa ilaaha illa Anta! Allohumma, inniy a’uuzu bika minal kufri val faqri va a’uuzu bika min ‘azabil qobri laa ilaaha illa Anta». \n" +
                                "(Ma’nosi: «Allohim, badanimni, qulog‘imni va ko‘zimni (sog‘lom) ofiyatda qil. Allohim, Sening noming ila kufrdan, kambag‘allikdan va qabr azobidan panoh tilayman. Sendan boshqa iloh yo‘q). (Abu Dovud va Ahmad rivoyati).\n" +
                                "Shu bilan bir qatorda, xastaliklardan sadaqa berish bilan ham davolanish mumkin. Bu haqda Nabiy alayhissalom: «Bemorlaringizni sadaqa bilan davolang» deganlar \n" +
                                "(Termiziy rivoyati). \n" +
                                "Yuqoridagi barcha fikrlarimizdan xulosa qiladigan bo‘lsak, Alloh taolo mo‘min bandalariga dard yoki musibat berar ekan, bandalari o‘ylaganlaridek, ularga zulm qilib emas, balki marhamat ko‘rsatib ularni sinovdan o‘tkazish, ayrim xato va kamchiliklarini kechirish va darajalarini ko‘tarish gunohlariga kafforat bo‘lishi uchun g‘amxo‘rlik qilayotgani ayon bo‘ladi.\n" +
                                "\n" +
                                "Doniyor Fayz\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Bemorga o‘qiladigan duo 2":{
                        String []myString = new String[8];
                        myString[0] = "BEMORGA O‘QILADIGAN DUO";
                        myString[1] =  R.drawable.kasalkorish2 + "";
                        myString[2] =  "Bemor tanasidagi og‘riyotgan joyiga qo‘lini qo‘yib 3 marta :";
                        myString[3] =  "بِسْمِ اللهِ\n" +
                                "أَعُوذُ بِاللهِ وَقُدْرَتِهِ مِنْ شَرِّ مَا أَجِدُ وَأُحَاذِرُ\n";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.kasalkorish2+ "";
                        myString[6] = "\"Bismillaah\"ni  3 marta aytadi: \n" +
                                "\"A’uuzu billaahi va qudrotihi min sharri maa ajidu va uhaaziru\", deya 7 marta aytadi.\n";
                        myString[7] = "Allohdan va uning qudratidan men sezayotgan va xavfsirayotgan narsaning yomonligidan panoh so‘rayman" +
                                "\n" +
                                "\n" +
                                "BEMORLIK NIMA: AZOB - UQUBATMI YOKI SINOV?\n" +
                                "\n" +
                                "Inson borki hayoti davomida biror kasallikni boshidan kechiradi. Albatta, inson o‘z hayotining birdek ravon, musibatlarsiz o‘tishini xohlaydi. Ammo, «issiq jon» deganlaridek, kasallik turli insonlarda og‘ir yoki engil kechishi mumkin. Inson jisman dard chekar ekan, uning ruhiyatida ham albatta salbiy fikrlar kechadi. Bu ruhiy kechinmalar insonning yoshiga ham bog‘liq bo‘ladi. Inson yoshlikda kasallikni oson o‘tkazish bilan birga, u bu haqda chuqur o‘ylamaydi ham. Ammo yoshi o‘tgan sari kasallik unga guyoki doimiy hamrohdek tuyulib, hali u eri, hali bu eri og‘rishidan noliy boshlaydi. Hatto yomon hayollarga borib besabrlik qiladi va buni go‘yo Alloh taoloning g‘azabiga uchraganlik belgisi deb tushunadi. Aslida ham shundaymi? Zotan, har bir inson hayoti davomida turli qiyinchilik va musibatlarga duch keladi. Chunki hayotning o‘zi sinov va imtihonlardan iborat. Vaholanki, dard kelganda ba’zi insonlarning umidsizlikka tushib zaiflashib qolishlari ularning kasallik orqasidan keladigan hikmatlardan bexabar ekanliklarining alomatidir. Mo‘min musulmonga Alloh taolo tomonidan yuboriladigan barcha kasalliklar u uchun xayrlidir. Goho bandalar farz qilingan ibodatlarni to‘liq ado eta olmasliklari yoki solih amallari etarli bo‘lmasligi mumkin. Bunday holatda Alloh taolo ularga biror kasallik yoki musibat yuborib, O‘z huzurida ularning gunohlarini kechib, ulug‘ darajalarga ko‘taradi. Ushbu so‘zimizga quyidagi hadis dalil bo‘la oladi. Muhammad ibn Xolid as-Sulamiyning bobosidan qilingan rivoyatda: «Nabiy sollallohu alayhi vasallam: «Albatta, Allohdan bir bandaga martaba yozilgan bo‘lsa-yu, banda amali bilan unga etmagan bo‘lsa, Alloh uni jasadida yoki molida, yoki bolasida balo (musibat)ga giriftor qiladi. So‘ngra uni ana shunga, toki Allohdan uning uchun yozilgan martabaga erishtirguncha sabr qildiradi», – dedilar» \n" +
                                "(Abu Dovud rivoyati).\n" +
                                "\n" +
                                "Agar Alloh taolo dard va alamlarni yubormaganida edi, insonlar sog‘likning qadriga etmagan bo‘lar edilar. Ba’zida inson kasallik, g‘am-tashvish va faqirlik kabi musibatlar unga Alloh tamonidan yuborilgan ne’mat ekanligini anglab etishi zarur. Agar teranroq o‘ylab ko‘rsak, bu musibatlar bilib-bilmay qilgan gunohlarimiz uchun kafforat bo‘lishini tushunamiz. Diniy manbalardan ma’lumki, solih kishilar turli musibatlarga uchrab turishi YAratganning unga muhabbati alomatidir. Jumladan, kasallikning kelishi Alloh taoloning unga yaxshilikni iroda kilgani belgisidir. Bunday kishilar uchun musibat va kasalliklar Alloh taolo oldida ularning darajotlari ko‘tarilishiga vositadir. Bu fikrimizga Abu Hurayra roziyallohu anhudan rivoyat qilingan ushbu hadisi sharif misol bo‘la oladi. Rasululloh sollallohu alayhi vasallam: «Alloh kimga yaxshilikni xohlasa, uni biror musibatga mubtalo qiladi», – dedilar. \n" +
                                "(Buxoriy rivoyati).\n" +
                                "\n" +
                                "Dinimiz tarixiga nazar solsak ham yuqoridagi fikrlarimizni tasdiqlovchi misollarni keltirish mumkin. Ayrim payg‘ambarlarni ham bunday musibatlar chetlab o‘tmagan. Hattoki bashariyat sayyidi bo‘lmish Muhammad alayhissalom ham bemor bo‘lganlar. Ibn Mas’ud roziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallamning huzurlariga kirsam, u zot isitmalab yotgan ekanlar. Men: «Ey Allohning rasuli, siz qattiq isitmalayapsiz-a?» – desam, u zot: «Ha, men sizlardan ikki kishi isitmalagani kabi isitma bo‘laman», – dedilar. «Unda sizga ikki ajr bo‘ladimi?» – desam, «Ha, shu singari biror musulmonga aziyat etsa, tikonmi yoki undan kattarog‘i azob bersa, u bilan yomonliklari o‘chirilib, gunohlari xuddi daraxt bargidek to‘kilib ketadi», – dedilar»\n" +
                                "(Buxoriy va Muslim rivoyati).\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "BEMORNI ZIYORAT QILISh FAZILATI\n" +
                                "\n" +
                                "Kasallikning hikmatlari bilan birga, shu o‘rinda bemorlarni ziyorat qilish fazilatlari haqida ham tuxtalsak. Ushbu hadisi qudsiy bu fikrimizni yorqin ifodalab beradi. Abu Hurayra roziyallohu anhudan rivoyat qilinadi. Rasululloh sollallohu alayhi vasallam dedilar: «Alloh taolo Qiyomat kuni: «Ey odam bolasi, kasal bo‘ldim, meni ko‘rgani bormading», deydi. Shunda u kishi: «Ey Rabbim, qanday qilib seni ko‘rgani boraman? Sen olamlarning Rabbi bo‘lsang», deydi. Alloh esa: «Bilmaysanmi, falonchi bandam kasal bo‘ldi, lekin uni ko‘rgani bormading. Agar uni ko‘rgani borganingda uning huzurida meni topar eding», deydi. Alloh: «Ey odam bolasi, sendan ovqat so‘radim, menga uni bermading», desa, u kishi: «Ey Rabbim, qanday qilib seni ovqatlantiraman? Sen olamlar Rabbi bo‘lsang», deydi. Alloh esa: «Bilmaysanmi, falonchi bandam sendan ovqat so‘radi, lekin sen unga taom bermading. Agar unga ovqat berganingda huzurimdan uni topar eding», deydi. Alloh: «Ey odam bolasi, sendan suv talab qildim. Lekin meni suv bilan siylamading», desa, u kishi: «Ey Rabbim, nechuk seni suv ila siylayman? Vaholanki, sen olamlar Rabbi bo‘lsang», deydi. Alloh esa: «Falonchi bandam suv talab qildi. Sen unga suv bermading. Bilmaysanmiki, agar suv bilan siylaganingda, uni mening huzurimdan topar eding», deydi»\n" +
                                "(Muslim rivoyati).\n" +
                                "\n" +
                                "Ushbu hadisda e’tibor qaratishimiz lozim bo‘lgan alohida ta’kidlangan nozik bir lafz bor. Mazkur hadisdagi: «Agar unga ovqat berganingda huzurimdan uni (ajr-mukofotini) topar eding yoki «suv bilan siylaganingda, uni mening huzurimdan topar eding», lafzidan ko‘ra «Bilmaysanmi, falonchi bandam kasal bo‘ldi, lekin uni ko‘rgani bormading. Agar uni ko‘rgani borganingda uning huzurida meni topar eding», lafzi bo‘rttirib ko‘rsatilgani bejiz emas. Bu bilan bemor huzuriga ziyorat uchun borgan inson albatta Alloh taoloning rahmati va mag‘firatiga erishishi bashorat qilinmoqda. Shuningdek, Alloh taoloning boshqa bandalariga nisbatan xasta va bemorlarga ma’naviy yaqinligiga ishora qilinmoqda. E’tibor bering, bu erda: «uning huzurida meni topar eding» deyilishi bilan xasta va bemor kishilarga alohida e’tibor ko‘rsatish, ularning ko‘ngilini ko‘tarish, dil yaralariga malham bo‘lish kabi insoniy fazilatlar ulug‘lanmoqda. \n" +
                                "\n" +
                                "Demak, gap bemorni ziyorat qilish fazilatlari haqida ketar ekan, ziyorat qilish uchun borgan kishining bemor huzurida unga umid baxsh etadigan, ruhiyatini ko‘taradigan so‘zlar bilan siylash aynan sunnatga muvofiq ishlardan sanaladi. Bu borada Imom Buxoriy rivoyat qilishicha, Payg‘ambarimiz sollallohu alayhi vasallam bemorni ziyorat qilsalar: “Laa ba’sa, tohurun inshaalloh”, ya’ni «Zarari yo‘q, inshaalloh, (bu kasallik sizni), gunohlardan poklaydi», – deb aytardilar.\n" +
                                "Doniyor Fayz\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "Bemor uchun shifo topishning bir necha sabablari bor\n" +
                                "\n" +
                                "Bemor inson o‘ning dardiga Alloh shifo berishidan umidvor bo‘lishi bilan birga, dardining davosi uchun sabab bo‘ladigan turli vositalar haqida o‘ylashi ham tabiiydir. Darhaqiqat, Imom Buxoriy Abu Hurayra roziyallohu anhudan rivoyat qilgan hadisi sharifda: «Nabiy sollallohu alayhi vasallam: «Alloh qaysi bir dardni nozil qilgan bo‘lsa, albatta, uning shifosini ham tushirgandir», dedilar». Shunday ekan, bemor shifo vositasi sifatida tabiblarga murojaat qilishi, tibbiy muolajalardan foydalanishi o‘rinlidir. Ushbu vositalardan yana biri duodir. Chin ixlos bilan o‘zi va boshqalar tomonidan qilingan duolar orqali ham davo topish mumkin. \n" +
                                "Xususan, Nabiy alayhissalomdan keltirilgan hadislarda aytilganidek, har bir dardga shifo bo‘luvchi duolardan o‘qib yurish ham tavsiya qilinadi. Jumladan, Ibn Abbos roziyallohu anhudan rivoyat qilingan hadisda Rasululloh sollallohu alayhi vasallam: «Kim kasal ko‘rgani borganida, agar ajali etmagan bo‘lsa, uning huzurida etti marta: «As`alullohal ‘aziyma Robbal ‘arshil ‘aziymi an yashfiyaka», – desa, Alloh taolo uni kasalidan xalos qiladi», dedilar. \n" +
                                "(Ma’nosi: Ulug‘ Allohdan, buyuk arsh Rabbidan senga shifo berishini so‘rayman.) \n" +
                                "(Abu Dovud va Termiziy rivoyati). \n" +
                                "Shu kabi tongda va kechda uch martadan aytiladigan ushbu duo: «Allohumma, ‘afini fiy badaniy, Allohumma, ‘afini fiy sam’iy, Allohumma, ‘afini fiy basoriy, laa ilaaha illa Anta! Allohumma, inniy a’uuzu bika minal kufri val faqri va a’uuzu bika min ‘azabil qobri laa ilaaha illa Anta». \n" +
                                "(Ma’nosi: «Allohim, badanimni, qulog‘imni va ko‘zimni (sog‘lom) ofiyatda qil. Allohim, Sening noming ila kufrdan, kambag‘allikdan va qabr azobidan panoh tilayman. Sendan boshqa iloh yo‘q). (Abu Dovud va Ahmad rivoyati).\n" +
                                "Shu bilan bir qatorda, xastaliklardan sadaqa berish bilan ham davolanish mumkin. Bu haqda Nabiy alayhissalom: «Bemorlaringizni sadaqa bilan davolang» deganlar \n" +
                                "(Termiziy rivoyati). \n" +
                                "Yuqoridagi barcha fikrlarimizdan xulosa qiladigan bo‘lsak, Alloh taolo mo‘min bandalariga dard yoki musibat berar ekan, bandalari o‘ylaganlaridek, ularga zulm qilib emas, balki marhamat ko‘rsatib ularni sinovdan o‘tkazish, ayrim xato va kamchiliklarini kechirish va darajalarini ko‘tarish gunohlariga kafforat bo‘lishi uchun g‘amxo‘rlik qilayotgani ayon bo‘ladi.\n" +
                                "\n" +
                                "Doniyor Fayz\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qabristonga borganda":{
                        String []myString = new String[8];
                        myString[0] = "QABRISTONGA BORGANDA";
                        myString[1] =  R.drawable.qabriston2 + "";
                        myString[2] =  "Qabristonga borganda aytiladigan duo:";
                        myString[3] =  "اَلسَّلامُ عَلَيْكُمْ أَهْلَ الدِّيارِ، مِنَ المُؤْمِنِينَ والمسْلِمِينَ . وإنَّا ، إنْ شاءَ الله ، لَلاحِقُونَ . أَسْأَلُ اللهَ لَنَا وَلَكُمُ العَافِيَةَ";
                        myString[4] =  "Muslim 975, Mojar 1547";
                        myString[5] =  R.raw.qabriston+ "";
                        myString[6] = "Assalomu alaykum ahlad-diyaar minal mo‘miniyna val muslimiyn. Va innaa inshaa allohu lalaahiquuna. As-alulloha lanaa valakumul ‘afiyata\n";
                        myString[7] = " “Assalamu alaykum, mo‘min va musulmon diyor ahllari! Va Alloh xohlasa, biz ham sizlarning ketingizdan ergashuvchilarmiz. Biz o‘zimizga va sizlarga Allohning Ofiyatini (panohini) so‘raymiz”\n" +
                                "\n" +
                                "\n" +
                                "✅ Qabr ziyoratiga borilar ekan, qabr oldida yoki maxsus joyda Qur`oni karim oyatlaridan tilovat qilish mumkin. Odatda o`tib ketganlar nomidan xayr-ehsonlar etib turiladi. Qabrlarni ziyorat qilishning savobli amal ekaniga musulmonlarning jami ulamolari ittifoq qilganlar. Lekin, qabristonda tilovat qilish yoki o`lganlar ruhiga Qur`on bag`ishlash, ular nomidan xayr-ehsonlar qilish joizligi borasida turli fikrlar bildirilgan. Nima bo`lganda ham, bizning xalqimiz asrlar davomida qabristonlarni obod qilib kelganlar, qabrlar ziyoratiga tez-tez chiqib turganlar, o`tganlar ruhiga oyatlar o`qib bag`ishlashni odat qilganlar.\n" +
                                "\n" +
                                "✅ Inson mehr-oqibat farzandi. U uzoq ko`rishmagan odamlarini sog`inib, qo`msab yashaydi. Bu sog`inchning taftini bosish uchun ularni yo`qlab turadi. Odamlar bir-birlari bilan tez-tez uchrashib, bordi-keldi qilib, har xil o`tirishmalar, ziyofatlar va ma`rakalar tashkil qilib, mehmondorchilik, o`zaro yo`qlov kabilarni amalga oshiradilar. Shuning uchun ham, shariatda silai rahim – o`zaro qarindoshlik aloqalari va mehmondo`stlik fazilati yo`lga qo`yilgan. Inson dunyodan o`tib ketgan ota-onalarini, o`z yaqinlarini, qarindosh-urug`larini ham sog`inadi. Shuning uchun, shariatimizda qabrlarni ziyorat qilish mustahab va joiz amallardan hisoblanadi. Qabr ziyoratining yana bir xususiyati shuki, u insonni kim ekanini, oxiratni, dunyodagi o`rnini, Alloh huzuridagi burchini eslatib turadi. Qabr ziyoratiga da`vat qiladigan eng mashhur va a`lo darajada sahih bo`lgan hadisi shariflar mavjuddir. Ularda qabr ziyoratining xosiyati haqida bunday deyiladi:\n" +
                                "قد كنت نهيتكم عن زيارة القبور فزوروها فإنها تذكر الآخرة فإنها تذكركم الموت ألا فزوروها فإنه يرقّ القلب و تدمع العين فإن لكم فيها عبرة فإنها تزهد فى الدنيا\n" +
                                "“Men sizlarni qabrlar ziyoratidan qaytargan edim. Endi, ularni ziyorat qilaveringlar! Chunki, u oxiratni eslatadi, sizlarga o`limni esga soladi. Ey, ziyorat qilaveringlar. Chunki, u qalbni yumshatadi, ko`zni yoshlantiradi. Chunki, sizlarga unda ibrat bor. U dunyoda parhezkor qilib qo`yadi” (Muslim, Termiziy, Abu Dovud, Ibn Moja, Hokim, Tabaroniy rivoyatlari).\n" +
                                "Imom an-Nasoiy rahimahulloh rivoyat qilishlaricha, qabrlar ziyoratining fazilati sifatida: ولتزدكم زيارتها خيرا – “Ularning ziyorati sizlarga yaxshilikni ziyoda qiladi”, deyilgan.\n" +
                                "Demak, yuqoridagi mazkur hadisi sharifdan qabrlarni ziyorat qilishda ziyorat qiluvchiga asosan ikkita foyda borligi ma`lum bo`ladi:\n" +
                                "Birinchisi, Rasululloh sollallohu alayhi va sallam: “Qabr ziyorati oxiratni eslatadi, dunyoda zohid qiladi”, deganlar. Ya`ni, oxiratni eslatib, dunyoga hirs qo`yishdan saqlaydi. Inson ziyoratga borib, o`zini o`nglaydi, dunyoning bir o`tkinchi ekanligini eslaydi, odamzotdan o`zi qilgan yaxshiliklari qolishini anglaydi. To`plangan mol-dunyolar insonga vafo qilmasligi, bu dunyodan ulardan biror narsa olib keta olmasligi, faqatgina insonning xayrli amallari qolishi ziyorat asnosida ko`ngildan o`tadi. Shoir bunday degan ekan:\n" +
                                "Ziyorat kardam qabri shahanshohi Yaman,\n" +
                                "Dast barovard-u bar man dod kafan.\n" +
                                "Guftoki, “Az in saxovatam ayb makun,\n" +
                                "K-az in dunyo hamin rasid ast ba-man!”.\n" +
                                "Mazmuni: Yaman podshohining qabrini ziyorat qildim. U qo`lini chiqarib, menga kafanini berdi va “Mening bu saxovatimni ayb qilmagin, chunki, dunyodan menga shugina yetgan, xolos”, dedi.\n" +
                                " Ikkinchisi, qabr ziyorati Rasululloh sollallohu alayhi va sallam aytganlaridek, “qalbni yumshatadi, ko`zni yoshlantiradi”. Xalqimizda: “Ko`ngling cho`ksa, bozorga bor! Ko`ngling ko`tarilsa, mozorga bor!”, degan naql bor. Inson hayotda o`zi bilmagan holda manmanlikka, kibru havoga berilib qolishi mumkin. Inson o`z aybu nuqsonlarini gohida ko`rmay qoladi. Shuning uchun unday odamlarga qabr ziyorati juda foydali. Ayniqsa, boy-badavlat insonlar, mansab kursisiga o`tirganlar qabrlarni ko`proq ziyorat qilib turishi kerak.\n" +
                                "Ayol-qizlarning qabrlarni ziyorat qilishini ahli sunnat va jamoatdagi hanafiylikdan boshqa mazhab ulamolari makruh deganlar. Chunki, Imom at-Termiziy rahimahulloh va boshqa muhaddislar tomonidan: “Rasululloh sollallohu alayhi va sallam ko`p-ko`p ziyorat qiluvchi ayollarni la`natladilar”, degan hadisi sharif rivoyat qilingan. Ushbu hadisi sharifga asoslanib, ahli sunnat va jamoat ta`limotidan og`ishgan ayrim toifalar hatto ayollarning qabr ziyoratini haromga chiqaradilar. Hanafiy mazhabiga oid fiqhiy manbalarda esa ayollarning qabrlarni ziyorat qilishi joiz, deyilgan. Zotan, ayollar ham o`z ota-onalari hamda qarindoshlari qabrlarini ziyorat qilishga haqlidirlar. Bunga bir necha dalillar mavjud.\n" +
                                "Oysha onamiz raziyallohu anho: “Qabrlarni ziyorat qilganimda nima deyman?”, deb so`raganlar. Shunda, Rasululloh sollallohu alayhi va sallam: “Assalom, `ala ahl ad-diyor min al-mo«minin va-l-muslimin!”, deb salomlashasan”, deganlar. Buni muhaddislardan Imom Muslim rahimahulloh va Imom an-Nasoiy rahimahulloh rivoyat qilgan bo`lib, u ayollarning qabrlarni ziyorat qilishi mumkinligiga yoqqol dalil bo`la oladi.\n" +
                                "Oysha onamiz raziyallohu anho Payg`ambarimiz sollallohu alayhi va sallam vafotlaridan so`ng u zotning qabrlarini ziyorat qilib turganlar. Otalari Abu Bakr as-Siddiq raziyallohu anhu, mashhur sahoba Hazrati Umar raziyallohu anhu dafn qilingandan so`ng ham Oysha raziyallohu anhoning ziyoratga kirib turganligi ma`lum. Shuningdek, Oysha raziyallohu anho ukalari Abdurrahmon raziyallohu anhuning Makkadagi qabrlari ziyoratiga maxsus borganlari naql qilingan. Imom al-Bayhaqiy rahimahulloh rivoyat qilishicha, bir kuni Oysha raziyallohu anho ukalari Abdurrahmon raziyallohu anhuning qabrini ziyorat qilib qaytayotganlarida, unga: “Axir, Rasululloh sollallohu alayhi va sallam qabrlar ziyoratidan qaytargan emasmilar?!”, deyilgan. Shunda, Oysha raziyallohu anho: “Avval qabr ziyoratidan qaytarilgan edi, so`ng unga ruxsat berilgan”, deb javob berganlar.\n" +
                                "Muhaddislardan Imom Hokim rahimahulloh rivoyat qilishlaricha, Payg`ambarimiz sollallohu alayhi va sallamning qizlari Fotima raziyallohu anho o`z amakilari Hazrati Hamza raziyallohu anhuning qabrlarini har jum`a borib ziyorat qilib qaytar ekanlar.\n" +
                                "Yuqorida keltirilgan: “Rasululloh sollallohu alayhi va sallam ko`p-ko`p ziyorat qiluvchi ayollarni la`natladilar”, degan hadisi sharifni ulamolar ayollarning sabr-toqatlari kamligi, ular tezda ho`ngrab yig`i-sig`i qilaverishlari oqibatida aytilgan, deganlar. Shuningdek, “ko`p-ko`p”, deyilishidan ayollar o`z oilalari va uy ichi ishlariga qaramasdan ziyoratma-ziyorat yuraverishlaridan qaytarilgan. Ayollarning yarim yolang`och, boshyalang bo`lib ziyoratgohlarga borishlari, ayniqsa aziz avliyolarning huzurlarida bu holda turishlari, albatta, gunoh ishlardandir. Agar ayollar ust boshi yopiq holda, mahramlari bilan birga ziyoratgohlarga borsalar, yig`i-sig`i qilmasdan sabrli bo`lishib, oxiratni eslab, Allohni yod olsalar, ziyoratdan hech mone`lik yo`q.\n" +
                                "Qabr oldiga borganda, oyoq kiyimini yechish odobdandir. Qabrdagi kimsaga odob bilan, sekin salom beradi. Inson tirik vaqtida qanchalik hurmat-izzatga sazovor bo`lsa, vafot qilganidan so`ng ham shunchalik hurmat-izzatga loyiqdir. “Mishkot al-masobeh”da Oysha onamiz raziyallohu anhoning qabr ziyorati odobi borasida ajoyib gaplari keltirilgan:\n" +
                                "كنت أدخل بيتى الذى فيه رسول الله صلى الله تعالى عليه و سلم و انّى واضع ثيابى و أقول إنما هو زوجى و أبى فلما دُفن عمر رضى الله عنه معهم فوالله ما دخلته إلا و أنا مشدودة علىّ ثيابى حياء من عمر رضى الله عنه\n" +
                                "“Men Rasululloh sollallohu alayhi va sallam dafn qilingan uyimga yopinchiqlarimsiz ham kiraverar edim. “Mana bunisi zavjim, bunisi esa otam”, der edim. Umar raziyallohu anhu dafn qilinganidan so`ng esa, Allohga qasamki, Umar raziyallohu anhudan hayo qilganimdan kiyimlarimga o`ranib kirar edim” (Imom Ahmad rahimahulloh rivoyati).\n" +
                                "Salomlashuvda qabrning qibla tomoniga o`tib, yuzini qabrga qaratib turadimi yoki yuzini qiblaga qaratib turadimi, degan masalada hanafiy olimlar ikki xil fikr bildirganlar. Yurtdoshimiz Abullays as-Samarqandiy rahimahulloh yuzni qiblaga qarab turiladi, deganlar. Lekin, Ibn Umar raziyallohu anhuning: “Rasululloh sollallohu alayhi va sallamning qabrlariga kelib, yuzingni qabrga qaratib turishing sunnatdandir”, deganlari rivoyat qilingan. Shuningdek, Imomi A`zam Abu Hanifa rahimahullohning: “Men Madinada bo`lgan vaqtimda Abu Ayyub as-Saxtiyoniy rahimahulloh keldilar. Men uning orqasini qiblaga qilib, yuzini Rasululloh sollallohu alayhi va sallamning yuzlariga qaratib, ovozsiz yig`layotganiga qarab turardim”, deganlari ham fiqhiy manbalarda zikr qilingan. Shuning uchun, ziyoratchining qiblaga orqa qilib, qabrga yuzlanib turishi ko`proq qo`llab-quvvatlangan.\n" +
                                "Qabristonda dunyodan o`tib ketganlar bilan salomlashuv qanday bo`lishini Rasululloh sollallohu alayhi va sallam o`rgatganlar. Demak, Rasululloh sollallohu alayhi va sallam qilganlari va o`rgatganlaridek, quyidagicha salom va duoyi xayrlar qiladi:\n" +
                                "السلام على أهل الديار من المؤمنين و المسلمين و يرحم الله المستقدمين منكم و منا و المستأخرين و إنا إن شاء الله بكم لاحقون\n" +
                                " “Mo«min va muslimlar joyidagi odamlarga salomlar! Alloh sizdan va bizdan oldin o`tganlarni ham, bizdan keyin qoladiganlarni ham rahmat aylasin. Biz ham, Alloh xohlasa, sizga ergashuvchimiz” (Muslim rivoyati).\n" +
                                "السلام عليكم أهل الديار من المؤمنين و إنا إن شاء الله بكم للاحقون أسأل الله لنا و لكم العافية أنتم لنا فرط و نحن لكم تبع\n" +
                                "“Assalomu alaykum, mo«minlar diyoridagilar! Biz ham, Alloh xohlasa, sizga ergashuvchimiz.  Allohdan o`zimizga va sizlarga ofiyat so`rayman! Sizlar bizdan oldinda kutib oluvchisizlar, biz esa sizlarga tobe`larmiz” (Muslim va Nasoiy rivoyatlari).\n" +
                                "السلام عليكم دار قوم مؤمنين و أتاكم ما توعدون غدا مؤجلون و إنا إن شاء الله بكم لاحقون اللهم لأهل بقيع الغرقد\n" +
                                "“Assalomu alaykum, mo«minlar guruhining joyidagilar! Sizlarga va`da qilingan narsa keldi, ertaga qiyomatgacha muhlat berilgansizlar. Biz ham, Alloh xohlasa, sizga ergashuvchimiz. Ey, Alloh! Baqi` qabristonidagilarni mag`firat qil!” (Nasoiy rivoyati).\n" +
                                " السلام عليكم دار قوم مؤمنين و إنا إن شاء الله بكم لاحقون\n" +
                                "“Assalomu alaykum, mo«minlar qavmining hovlisida turganlar. Biz ham, Alloh xohlasa, sizga ergashuvchimiz” (Abu Dovud, Ibn Moja rivoyatlari).\n" +
                                " السلام عليكم يا أهل القبور يغفر الله لنا و لكم أنتم سلفنا و نحن بالأثر\n" +
                                "“Assalomu alaykum, ey qabristondagilar! Alloh bizni va sizni mag`firat qilsin. Sizlar bizdan oldingilarsiz, biz esa izdagilarmiz” (Termiziy rivoyati).\n" +
                                "السلام عليكم دار قوم مؤمنين أنتم لنا فرط و إنا بكم لاحقون اللهم لا تحرمنا أجرهم و لا تضلنا بعدهم\n" +
                                "“Assalomu alaykum, mo«minlar qavmining hovlisidagilar! Sizlar bizdan oldinda kutib oluvchisizlar, biz esa sizlarga ergashuvchilarmiz. Ey, Alloh! Bizni ularning ajridan mahrum qilma, ulardan keyin bizni adashtirma!” (Ibn as-Sunniy rivoyati).\n" +
                                "Qabr ziyoratidagi uchinchi xosiyat shuki, unda ziyorat qilinayotgan odamga, qabr egasiga ham foyda yetkazish bor. Duoyi xayr qilinsa, Qur`on tilovat etilsa, duo va tilovatning savobi o`lganlarga albatta yetib boradi. Imom al-Bayhaqiy rahimahulloh rivoyat qilishlaricha, Rasululloh sollallohu alayhi va sallam bunday deb marhamat qilganlar: “Qabrdagi o`lik madad istayotgan g`arq bo`luvchi kabidir. U otasidan, onasidan, aka-ukasidan yoki do`stidan yetib keladigan duoga intizor bo`ladi. Duo yetib kelsa, bu unga dunyo va undagi bor narsadan yaxshiroqdir. Shak yo`qki, Alloh azza va jalla qabr ahliga yer ahlining duosini tog`lar misoli qilib kiritadi. Tiriklarning o`liklarga qilgan hadiyasi ularga istig`for aytishdir!”. Shuning uchun, yuqoridagi keltirilganlaridek, salomlashib bo`lgandan so`ng o`zi bilgan kichik suralar va salovatlarni tik turgan holda o`qiydi. Masalan, “surai fotiha” va “oyat al-kursiy” bir martada, “ixlos surasi” o`n bir marta va uch marta o`zi bilgan salovatlardan o`qib, savobini mayyitga bag`ishlash tavsiya qilingan. Keyin chetroqqa o`tib o`tirib, boshqa uzun suralardan, masalan, “yosin” va “taborak” suralarini o`qiydi. Butun bor istaklarini Alloh taolodan so`raydi.\n" +
                                "Qabrlar ziyoratidan oldin yoki keyin ikki rak`at nafl namoz o`qib, uning savobini ziyorat qilinganlarga bag`ishlash va ular haqqiga istig`for aytish tavsiya qilinadi. Chunki, Imom at-Tabaroniy rahimahulloh rivoyatida bunday deyilgan: واجعلوا زيارتكم لها صلاة عليهم و استغفارا لهم – “Ziyoratlaringizda qabrdagilar foydasiga namoz va istig`for ham ado qilib qo`ying!”.\n" +
                                "Demak, qabr ziyoratining to`rtinchi xosiyati shu yerda ma`lum bo`ladi. Qabr sohiblaridan ziyorat qiluvchilarga manfaat yetishi ham bor. Bu ikki jihatdan sodir bo`ladi. Fayzu baraka yetadi va qabr oldida qilingan duolar ijobat bo`ladi. Qabr oldida duo qilishni Rasululloh sollallohu alayhi va sallamning o`zlari o`rgatganlar. Payg`ambarimiz alayhissalom qabrlar ziyoratiga borganda, “Alloh sizdan va bizdan oldin o`tganlarni ham, bizdan keyin qoladiganlarni ham rahmat aylasin!”, “Alloh bizni ham, sizni ham mag`firat qilsin!”, “Allohdan biz uchun ham, sizlar uchun ham ofiyat so`rayman!”, “Ey, Alloh! Ularning ajru savoblaridan bizni mahrum qilmagin, ulardan keyin bizni adashtirmagin!”, deb duo qilganlari va shu xilda duo qilishni o`rgatganlari naql qilingan. Shuning uchun, Imom an-Navaviy rahimahulloh “al-Azkor” asarlarida ziyoratchi qabr oldida Qur`on qiroati, zikrlarni va duolarni ko`p qilishni, ulug` va fazilatli zotlarning qabrlari oldida esa uzoq turishni maqbul amallardan, deb ta`kidlaganlar.\n" +
                                "Qabrdagi zot ulug` avliyolardan bo`lsa, yoki Rasululloh sollallohu alayhi va sallam bo`lsalar, duo qilish asnosida ularning nomlarini tilga olib, “Ey, Alloh! Shu zoti sharifning hurmatidan duoimni qabul qilgin!” deya duosini yakunlaydi. Bu xilda ziyorat qilinayotgan zotning nomini duoda tilga olib, ziyoratchi Alloh taolodan istaklarini so`rashi “tavassul” deb ataladi.\n" +
                                "Musulmonlarning Alloh taologa duo qilishlari farz amallardan bo`lib, bandaning bandaligi ana shu duosi bilandir! Duo qilmaydigan banda Allohning marhamatiga erisha olmaydi. Alloh o`z bandasining unga yolvorib, duo qilishini yaxshi ko`radi. Alloh taolo biz bandalarga bunday deb buyurgan:\n" +
                                "أدعوا ربكم تضرّعا و خفية إنه لا يحبّ المعتدين\n" +
                                "“Parvardigoringizga tazarru va maxfiy holda duo qilinglar! Albatta, Ul zot haddidan oshganlarni yaxshi ko`rmas” (A`rof, 55).\n" +
                                "Mazkur oyati karimadagi “haddan oshish”da baqirib duo qilish, duo lafzlarida sergaplik qilish bilan birga umuman duo qilmay qo`yish ma`nolari ham bor. Shuning uchun ham Payg`ambarimiz sollallohu alayhi va sallam: “Allohga duo qilmagan kimsaga Alloh g`azab qiladi”, deganlar. Modomiki, banda duo qilar ekan, uning duosini Alloh taolo ijobat qiladi. Alloh taoloning go`zal ismlari: “Rahiym”, “Rauf”, “Tavvob”, “Mujib”, “Afuv”, “Nofi`” kabi sifatlari bandalarning duolarini qabul qilishiga ishora qilib turadi. Shuning uchun ham Alloh taolo Qur`oni karimda bunday degan:\n" +
                                " وَإِذَا سَأَلَكَ عِبَادِي عَنِّي فَإِنِّي قَرِيبٌ أُجِيبُ دَعْوَةَ الدَّاعِ إِذَا دَعَانِ فَلْيَسْتَجِيبُوا لِي وَلْيُؤْمِنُوا بِي لَعَلَّهُمْ يَرْشُدُونَ\n" +
                                "“Sizdan (ey, Muhammad!) bandalarim Mening haqimda so`rasalar, (ayting) Men ularga yaqinman. Menga iltijo qiluvchining duosini ijobat eturman. Bas, ular ham Meni (da`vatlarimni) ijobat (qabul) etib, Menga imon keltirsinlar, shoyad (shunda) to`g`ri yo`lga tushib ketsalar” (Baqara, 186).\n" +
                                "Biroq, duo qiluvchi inson, odatda, duosining tezda ijobat bo`lishini istaydi, bu borada qandaydir vositalar izlaydi. Ana shunday vositalar jumlasidan duosi ijobat bo`ladigan odamlarga duo qildirish, ulardan duo olish, Alloh taolo oldida hurmati va qadri bor narsalarni va shunday kimsalarni o`z duosida tilga olish kabilardir.\n" +
                                "Demak, “tavassul” arabcha so`z bo`lib, lug`atda “etishmoq”, “visol istamoq”, “yalinmoq”, “o`tinch qilmoq”, “iltimos qilmoq” ma`nolarida ishlatiladi. “Tavassul”ni yana “vasila”, ya`ni “vosita, usul, chora, asbob” ma`nosida ham qo`llaniladi. Bu ma`nolarning barchasini qamrab olgan holda “tavassul”ning shar`iy ma`nosi shakllangan. Unga ko`ra, “tavassul” – “duosi tezda ijobat bo`ladi”, deb umid qilingan biror solih zotning o`zi bo`lsa o`zini, agar o`zi bo`lmasa uning nomini keltirib u orqali Alloh taologa duo qilishdir”.\n" +
                                "Uzoq masofalarda joylashgan ulug` zotlarning qabrlarini ziyorat qilishga atayin niyat qilib borish, ayniqsa, payg`ambarimiz Rasululloh sollallohu alayhi va sallamning muborak qabrlarini ziyorat qilish maqsadida yo`lga chiqishni ahli sunnat va jamoat ta`limotiga ergashgan ulamolar, ya`ni to`rt mazhabning biriga amal qiluvchi olimlar joiz deganlar. Taniqli hanafiy olimi Kamoliddin ibn al-Humom rahimahulloh “al-Hidoya”ga bitgan mashhur “Fath al-qadir” nomli sharhlarida Payg`ambarimiz sollallohu alayhi va sallamning qabrlarini ziyorat qilishni mustahab amallarning eng afzali, deganlar. Manbalarda vaqti va moli yetarli odamga Payg`ambarimiz sollallohu alayhi va sallamning qabrlarini ziyorat qilishni vojibga yaqin amal deb zikr etilgan. Jumladan, taniqli hanafiy olimi Mavlono Ali al-qori rahimahulloh “Sharh Lubob al-manosik” asarida bunday deb qayd qilganlar:\n" +
                                "“Bilginki, payg`ambarlar sayyidi sollallohu alayhi va sallamning qabrlarini ziyorat qilish imkoni bor kimsa uchun musulmonlarning ijmo`si bilan qurbatlarning eng ulug`i, toatlarning eng afzali, darajalarga erishishda sa`y-harakatlarning eng najotkorrog`i,  vojiblar darajasiga yaqin amaldir. Bu borada muxoliflarning gapiga e`tibor berilmasligi kerak. Ziyoratni tark etish ulug` g`aflat va katta jafodir. Ayrim molikiylar Madinaga borishni bir marta haj qilgandan keyin Ka`ba va Baytulmuqaddasga borishdan afzaldir, deyishgan…”.\n" +
                                "Shu yerda Ali al-qori rahimahulloh muhaddis Ibn Adiy rahimahullohning: من حجّ البيت و لم يزرنى فقد جفانى – “Kimki Baytullohni haj qilgandan so`ng meni ziyorat qilmasa, darhaqiqat, menga jafo qilibdi!”, degan hadislarini zikr qilganlar. Uni “hasan sanadli”, deb turib, hujjat qilishga e`tiborli ekanini alohida ta`kidlaganlar.\n" +
                                "Shuningdek, Imom ad-Doraqutniy rahimahulloh va Imom al-Bazzor rahimahulloh Payg`ambarimiz sollallohu alayhi va sallamdan rivoyat qiladilar:\n" +
                                "من زار قبرى وجبت له شفاعتى\n" +
                                "“Kimki mening qabrimni ziyorat qilsa, unga mening shafoatim vojib bo`lur!”.\n" +
                                "Yana Imom ad-Doraqutniy rahimahulloh Janobi Rasululloh sollallohu alayhi va sallamdan taxrij qilgan:\n" +
                                "من جاءنى زائرا لا تعلمه حاجة الا زيارتى كان حقا على ان أكون له شفيعا يوم القيامة\n" +
                                "“Kimki mening ziyoratimga kelsa, unda faqat ziyoratimnigina hojat-ehtiyoj deb amal qilsa, qiyomat kuni unga shafi` bo`lishimga haqqi bo`ladi”.\n" +
                                "Imom ad-Doraqutiy rahimahulloh yana rivoyat qilgan. Rasululloh sollallohu alayhi va sallam marhamat qilganlar:\n" +
                                "من حجّ و زار قبرى بعد موتى كان كمن زارنى فى حياتى\n" +
                                "“Kimki haj qilsa va o`lganimdan so`ng qabrimni ziyorat qilsa, xuddi tirikligimda meni ziyorat qilgandek bo`lur”.\n" +
                                "Bu xildagi hadisi shariflar juda ko`pchilikni tashkil qiladi. Ularni to`plab olimlar alohida kitoblar ham yaratganlar. Biroq, XIV asrdan boshlab islom olamida paydo bo`lgan: “Rasululloh sollallohu alayhi va sallamning muborak qabrlari ziyoratlariga uzoq joylardan maxsus niyat qilib yo`lga chiqish mumkin emas!”, degan fikr hozirgacha davom etib kelmoqda. Rasululloh sollallohu alayhi va sallamning qabrlarini ziyorat etishni, u yerda duo-yu fotihalar qilmoqni niyat qilib safar qilishni hatto butlarni haj qilishga borish deb hukm qilgan kimsalar ham mavjud. Butun dunyo bo`ylab ayrim musulmonlarning adashuvi, yanglishuvi, oxiri tugamas tortishuvlariga sababchi bo`lgan ushbu noto`g`ri fikrning kelib chiqishiga faqatgina birgina hadis mazmuni sabab bo`lgan:\n" +
                                "لا تشدّ الرحال الا الثلاثة مساجد المسجد الحرام و مسجدى هذا و المسجد الأقصى\n" +
                                "“Uchta masjiddan boshqasiga bel bog`lab chiqilmaydi: Masjidi harom, mening bu masjidim va Aqso masjididir”.\n" +
                                "Biroq, mazkur hadisi sharifda aynan qabrlar ziyorati borasida birorta gap ham, birorta ishora ham yo`q! Bu hadisda faqatgina masjidlar nazarda tutilganligi ko`rinib turibdi. Ana shu uchta masjiddan boshqa masjidlarda o`qilgan namoz va ibodatlarning darajalari bir xil ekani sir emas. Bu hadisda tilga olingan masjidlarda ado etilgan ibodatlarning savobi boshqalariga nisbatan ancha ko`pdir. Bu borada alohida hadisi shariflar ham mavjud. Masjidi haromda o`qilgan namoz yuz ming namozga, Masjidi nabaviyda o`qilgan namoz ming namozga, Baytulmuqaddasda o`qilgan namoz esa besh yuz namozga tengligi borasidagi hadislarni ko`pchilik eshitgan. Bulardan boshqa masjidlar borasida alohida fazilatlar va`da qilingan emas. Boshqa masjidlarda o`qilgan jamoat namoziga esa bir xilda – va`da qilingan 25-27 daraja savobni olish mumkin, xolos. Demak, boshqa masjidlarga alohida niyat qilib uzoq joydan safar qilib borishda sayru tamoshodan boshqa ortiqcha savobni olish mushkil. Shuning uchun, hadisda boshqa masjidlar ziyoratiga niyat qilib chiqilmaydi, deyilgan. Agar alohida niyat qilib yo`lga chiqilmaydigan narsalarga masjiddan boshqa narsalar ham kiradi, deyiladigan bo`lsa, odam uzoqdagi qarindosh-urug`larining ziyoratiga ham, bemor yotgan birodarining kasalko`rdisiga ham, to`y-ma`rakaga ham, aziz va ulug` insonlarning  duosini olishga ham, ilm olish niyatida uzoq joylarga safar qilishga ham, hatto tijorat safariga ham bora olmay qolardi. Ana shuning uchun mazkur hadisning aynan Imom Ahmad rahimahulloh qilgan rivoyatida: «Namozxon uchun namoz o`qishni istab quyidagi masjidlardan boshqasiga ko`ch bog`lab, yo`lga chiqish yaxshi bo`lmaydi. Masjidi harom, masjidi aqso va mening masjidim», deyilgan. Shuningdek, «Ulovchiga Masjidi Harom, Masjidi Aqso va mening mana bu Masjidimdan boshqasida namoz o`qishni niyat qilib, birorta masjidga tomon bel bog`lab, ko`ch bog`lab, yo`lga tushishi to`g`ri kelmaydi», degan hadisi sharif ham mavjud. Bu hadislarda ana shu uchta masjiddan boshqasida namoz o`qishni niyat qilib safar qilishdan qaytarilgani ravshan bo`lib turibdi.\n" +
                                "Qachon Madinaga yetib kelsa, uning tashqarisida shaharga kirmasdan avval g`usl qiladi yoki yangi tahorat qiladi. G`usl qilish afzal. Pokiza va yangi kiyimlar kiyish afzal. Odamlarning ba`zisi ushbu ishlarni Madina yaqinida maxsus tushib bajarib oladilar. Madinaga kirayotganda yoki aynan Masjidi nabaviyga borishda qadamlari bilan yurib borish yaxshidir. Odobu ulug`lashga kiradigan har bir narsa yaxshi bo`laveradi. So`ngra, bu tabarruk ziyorat hosil bo`lgandan keyin Masjidi nabaviy ziyoratiga kirishsin! Ulug` ziyoratning nasib qilgani uchun Alloh taologa shukronalar keltirsin. Chunki, mana shu ishda Rasuli akram sollallohu alayhi va sallamning ta`zimi bor, unda ulug`lash mavjud.\n" +
                                "Rasululloh sollallohu alayhi va sallamning muborak qabrlarini ziyorat qilish insonga umrida bir marta yoki bir necha marta nasib qilishi mumkin. Albbata, imkon tug`ilganda bu fazilatdan aslo benasib qolmaslik kerak. Biroq, inson o`z ota-onasining qabrlarini, qarindosh-urug`lari, ustozlari va yaqin do`st-birodarlarining qabrlarini  tez-tez ziyorat qilishga doimo imkon tug`iladi. Bu imkoniyatdan hamisha unumli foydalanish musulmonlik xislatlaridan biridir. Umuman ziyoratga bormaslik, ota-onaning qabrlarini hatto qaerdaligini unutib yuborish, ziyoratni yomon ko`rish insonning to`g`ri yo`lda emasligini bildiradi. Imom at-Tabaroniy rahimahulloh va Imom al-Bayhaqiy rahimahulloh tomonlaridan: “Kimki ota-onasining yoki ulardan birovining qabrini har jum`ada ziyorat qilsa, uni kechiriladi va yaxshi inson deb yoziladi”, degan hadisi sharif rivoyat qilingan.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Bozorga kirishda":{
                        String []myString = new String[8];
                        myString[0] = "BOZORGA KIRISHDA O‘QILADI";
                        myString[1] =  R.drawable.bozorgakirish2 + "";
                        myString[2] =  "Bozorga kirayotganda o‘qiladigan duo:";
                        myString[3] =  "لاَ إِلَهَ إِلاَّ اللَّهُ وَحْدَهُ لاَ شَرِيكَ لَهُ، لَهُ الْمُلْكُ، وَلَهُ الْحَمْدُ، يُحْيِي وَيُمِيتُ، وَهُوَ حَيٌّ لاِ يَمُوتُ، بِيَدِهِ الْخَيْرُ، وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ";
                        myString[4] =  "Termiziy 3428, ibn Mojar 3860, al-Xakim 1/538";
                        myString[5] =  R.raw.dua218+ "";
                        myString[6] = "La ilaha illa-llbhu vaxdaho‘ la sharyka lah, lahu-l-mulku va-lahu-l-xamdu yuxyy va-yumyt, va-huva xayyul-la yamo‘t, bi-yadihi-l-xoyr, va-huva ‘ala kulli shay'in qodyr.";
                        myString[7] = "«Yagona, sherigi bo‘lmagan Alloxdan boshqa iloh yo‘q. Mulk Unikidir. Hamd Unga xosdir. Tiriltiruvchi va o‘ldiruvchi Udir. U tirikdir. Xayr (yaxshilik) Undandir. U har narsaga qodirdir».\n" +
                                "Yuqoridagi duo haqida Umar roziyallohu anhudan rivoyat qilingan hadisda Payg‘ambarimiz sollallohu alayhi va sallam shunday deganlar:\n" +
                                "«Kim bozorga kirganda ushbu duoni o‘qisa, Alloh unga behisob hasana yozadi, undan behisob yomonlikni o‘chiradi. Darajasini ham shunchalik ko‘taradi». \n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Sizga yaxshilik qilganga duo":{
                        String []myString = new String[8];
                        myString[0] = "SIZGA YAXSHILIK QILGANGA";
                        myString[1] =  R.drawable.sizgayaxshilik2 + "";
                        myString[2] =  "Sizga yaxshilik qilgan kishiga aytadigan duoingiz:";
                        myString[3] =  "جَزاكَ اللهُ خَـيْراً";
                        myString[4] =  "Termiziy 2035, Saxixul-Djomiy 6244";
                        myString[5] =  R.raw.dua201+ "";
                        myString[6] = "Jazakallohu hayron.";
                        myString[7] = "Alloh sizni taqdirlasin (mukofotlasin).\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Musibatli kishini ko'rganda":{
                        String []myString = new String[8];
                        myString[0] = "MUSIBATLI KISHINI KO'RGANDA";
                        myString[1] =  R.drawable.balolangan2 + "";
                        myString[2] =  "Bir musibatli kishini ko‘rganda o‘qiladigan duo:";
                        myString[3] =  "الْحَمْدُ لِلَّهِ الَّذِي عَافَانِي مِمَّا ابْتَلاَكَ بِهِ، وَفَضَّلَنِي عَلَى كَثِيرٍ مِمَّنْ خَلَقَ تَفْضِيلاً";
                        myString[4] =  "Termiziy 3432";
                        myString[5] =  R.raw.dua196+ "";
                        myString[6] = "Alhamdulillahillaziy 'afani mimmabtalaka bihi, vazzolani 'ala aksirim miman xalaqo tafzila.";
                        myString[7] = "Allohga hamdlar bo'lsin, Yaratgan ko'plab kishilarga berilgan balolardan, meni omon saqladai.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "G‘azablanganda o‘qiladigan duo":{
                        String []myString = new String[8];
                        myString[0] = "G‘AZABLANGANDA O‘QILADIGAN DUO";
                        myString[1] =  R.drawable.gazab2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi va sallam g‘azablangan insonga tahorat olishni, turgan bo‘lsa o‘tirishni, o‘tirgan bo‘lsa, yotib olishni tavsiya qilish bilan birga:";
                        myString[3] =  "الْحَمْدُ لِلَّهِ الَّذِي عَافَانِي مِمَّا ابْتَلاَكَ بِهِ، وَفَضَّلَنِي عَلَى كَثِيرٍ مِمَّنْ خَلَقَ تَفْضِيلاً";
                        myString[4] =  "Buxoriy 141, Muslim 2610";
                        myString[5] =  R.raw.auzubillah+ "";
                        myString[6] = "A’o‘zu billaxi mina-sh-shaytbni-r-rojym";
                        myString[7] = "«Toshbo‘ron qilingan shayton yomonligidan Alloxdan najot so‘rayman», deyishni o‘rgatganlar.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Aksirganda o‘qiladigan duo":{
                        String []myString = new String[8];
                        myString[0] = "AKSIRGANDA O‘QILADIGAN DUO";
                        myString[1] =  R.drawable.aksurganda2 + "";
                        myString[2] =  "Payg‘ambarimiz sollallohu alayhi va sallam: «Musulmonning musulmondagi haqqi oltitadir», - deganlar. Shulardan biri qachon aksa ursa va Allohga hamd aytsa, unga yaxshilik tilashdir.\n" +
                                "Kim aksirsa:\n";
                        myString[3] =  "الْحَمْـدُ للهِ -يَرْحَمُـكَ الله -يَهْـديكُـمُ اللهُ وَيُصْـلِحُ بالَـكُم";
                        myString[4] =  "Buxoriy 5870";
                        myString[5] =  R.raw.dua190+ "";
                        myString[6] = "1.\t«Al-hamdu li-llah» \n" +
                                "2.\t«Yarxamuka-llbh»\n" +
                                "3.\t«Iahdykumu-llbhu va-yuslixu balakum»\n";
                        myString[7] = "1.\t-«Allohga hamd bo‘lsin», - deb aytsin.\n" +
                                "Buni eshitgan odam:\n" +
                                "2. - «Alloh Senga rahm qilsin», - deb javob bersin. Aksirgan inson javoban:\n" +
                                "3. - «Alloh sizlarni ham hidoyat qilsin va isloh qilsin», - desin.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Taomlangandan avval":{
                        String []myString = new String[8];
                        myString[0] = "OVQATDAN AVVAL";
                        myString[1] =  R.drawable.ovqatdanoldin2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi va sallam qilayotgan har bir ishlarining boshida Allohning ismini tilga olar edilar. Ovqatlanishdan avval U zot sollallohu alayhi va sallam qo‘llarini yuvar, o‘ng qo‘l bilan o‘z oldilaridan boshlashdan avval:\n";
                        myString[3] =  "بسم الله الرحمن الرحيم";
                        myString[4] =  "Abu Dovud 3767";
                        myString[5] =  R.raw.bismillyahi+ "";
                        myString[6] = "Bismillahi-r-rohmani-r-rohym";
                        myString[7] = "«Mehribon va rahmli Alloh nomi bilan boshlayman», - der edilar." +
                                "OVQATLANISH ODOBI\n" +
                                "\n" +
                                "Ey o‘g‘ilcham! Agar sen ovqatlanishni istasang, uning odoblariga rioya qil. Ovqatlanishdan oldin ham, keyin ham qo‘lingni yuv. \"Bismillah\" deb boshla, \"Alhamdulillah\" deb tugat. O‘ng qo‘ling bilan eyish va o‘ng qo‘ling bilan ichishni unutma. Payg‘ambarimiz sollallohu alayhi vasallam: \"Agar sizlardan biringiz ovqatlanishni istasa, o‘ng qo‘li bilan eb, o‘ng qo‘li bilan ichsin\", deganlar. Ovqatlanayotgan vaqtda ko‘p so‘zlashdan tiyil. O‘ngga va chapga o‘girilib qarayverma. Yoshi ulug‘ va darajasi sendan baland bo‘lgan odamdan yuqorida o‘tirma. Taomingga puflama, qaynoq holatida yema. Eningdagi odamning luqmasiga ko‘zingni yugurtirma. Tez yema. Shoshib-pishib esang, kiyiminga ovqat to‘kiladi. Ovqat og‘zingda turganda gapirma. Yo‘talging yoki aksirging kelib qolsa, dasturxondan chekkaroqqa o‘t. Bir ovqatni hazm qilmasdan ikkinchi ovqatni yema. Ustma-ust ovqatlanish sihat-salomatlikka zarardir. Ya’ni, qorning ochmasdan turib ovqatlanma. Yo‘lda ketayotib eyishdan hazar qil. Chunki yurib borayotganda kavshanish odobsizlikdir. O‘tirgan holatda, og‘izga kichkina luqma solib, chaynab eyish odobdandir.\n" +
                                "\n" +
                                "Abduqayum Hikmat tayyorladi.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Taomlangandan avval 2":{
                        String []myString = new String[8];
                        myString[0] = "OVQATDAN AVVAL 2";
                        myString[1] =  R.drawable.ovqatdanoldin2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi va sallam, ovqatlanishdan avval bunday deyishni unutganlarga:\n";
                        myString[3] =  "بسمِ اللَّهِ فِي أَوَّلِهِ وَآخِرِهِ";
                        myString[4] =  "Abu Dovud 3767";
                        myString[5] =  R.raw.dua179+ "";
                        myString[6] = "Bismillahi avvalahu va axirohu";
                        myString[7] = "«Avvalida ham, oxi-rida ham Allohning nomi bilan boshlayman», - deyish kerakligini aytganlar." +
                                "OVQATLANISH ODOBI\n" +
                                "\n" +
                                "Ey o‘g‘ilcham! Agar sen ovqatlanishni istasang, uning odoblariga rioya qil. Ovqatlanishdan oldin ham, keyin ham qo‘lingni yuv. \"Bismillah\" deb boshla, \"Alhamdulillah\" deb tugat. O‘ng qo‘ling bilan eyish va o‘ng qo‘ling bilan ichishni unutma. Payg‘ambarimiz sollallohu alayhi vasallam: \"Agar sizlardan biringiz ovqatlanishni istasa, o‘ng qo‘li bilan eb, o‘ng qo‘li bilan ichsin\", deganlar. Ovqatlanayotgan vaqtda ko‘p so‘zlashdan tiyil. O‘ngga va chapga o‘girilib qarayverma. Yoshi ulug‘ va darajasi sendan baland bo‘lgan odamdan yuqorida o‘tirma. Taomingga puflama, qaynoq holatida yema. Eningdagi odamning luqmasiga ko‘zingni yugurtirma. Tez yema. Shoshib-pishib esang, kiyiminga ovqat to‘kiladi. Ovqat og‘zingda turganda gapirma. Yo‘talging yoki aksirging kelib qolsa, dasturxondan chekkaroqqa o‘t. Bir ovqatni hazm qilmasdan ikkinchi ovqatni yema. Ustma-ust ovqatlanish sihat-salomatlikka zarardir. Ya’ni, qorning ochmasdan turib ovqatlanma. Yo‘lda ketayotib eyishdan hazar qil. Chunki yurib borayotganda kavshanish odobsizlikdir. O‘tirgan holatda, og‘izga kichkina luqma solib, chaynab eyish odobdandir.\n" +
                                "\n" +
                                "Abduqayum Hikmat tayyorladi.\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Taomlangandan so‘ng":{
                        String []myString = new String[8];
                        myString[0] = "TAOMLANGANDAN SO‘NG";
                        myString[1] =  R.drawable.ovqatdansong2 + "";
                        myString[2] =  "Anas ibn Molik roziyallohu anhudan rivoyat qilinadi:\n" +
                                "«Nabiy sollallohu alayhi va sallam: «Ovqatlangandan so‘ng mana bu duoni o‘qiganning avvalgiyu keyingi gunohlari magfirat qilinadi», - dedilar:\n";
                        myString[3] =  "الْحَمْدُ ِللهِ الَّذِي أَطْعَمَنِي هَذَا وَرَزَقَنِيهِ مِنْ غَيْرِ حَوْلٍ مِنِّي وَلَا قُوَّةٍٍ";
                        myString[4] =  "Abu Dovud 4025, Termiziy 3458, ibnu Mojar 3285";
                        myString[5] =  R.raw.dua182+ "";
                        myString[6] = "Alhamdulillaahil laziy at’amanii haazaa va rozaqoniihi min g‘oyri havlin minniy valaa quvvah";
                        myString[7] = "«Shuni mening kuch-quvvatimsiz menga taom qilib, rizq qilib bergan Allohga hamd bo‘lsin» desa, uning avvalgi gunohlari mag‘firat qilinadi», dedilar»." +
                                "Izoh. Mazkur hadis sharhida ulamolar: \"Bu erda bilib-bilmay qilingan sag‘ira gunohlar tavbasiz ham ushbu duo sababli mag‘firat qilinishi haqida gap ketmoqda. Kabira gunohlarga esa tavba shart\", deyishadi.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Taomlangandan so‘ng 2":{
                        String []myString = new String[8];
                        myString[0] = "TAOMLANGANDAN SO‘NG 2";
                        myString[1] =  R.drawable.ovqatdansong2 + "";
                        myString[2] =  "Abu Umoma roziyallohu anhu rivoyat qiladi:\n" +
                                "«Rasululloh sollallohu alayhi va sallam dasturxon yig‘ilganda shunday duo qilar edilar:\n";
                        myString[3] =  "الْحَمْدُ لِلَّهِ حَمْداً كَثِيراً طَيِّباً مُبَارَكاً فِيهِ، غَيْرَ [مَكْفِيٍّ وَلاَ ] مُوَدَّعٍ، وَلاَ مُسْتَغْنَىً عَنْهُ رَبَّنَا";
                        myString[4] =  "Buxoriy 5458, Termiziy 3456";
                        myString[5] =  R.raw.dua183+ "";
                        myString[6] = "Al-xamdu li-llahi hamdan kasyran toyyibam-muba-rokan fyhi g‘oyro muvadda’in va-la mustag‘nan ‘anho‘ rob-buna";
                        myString[7] = "Allohga ko‘pdan-ko‘p pok, muborak hamd bo‘lsin. Undan o‘zga kifoyachi yo‘q. U tark qilingan ham emas. Undan behojat ham bo‘linmas. Robbimiz.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yangi oyni ko‘rganda":{
                        String []myString = new String[8];
                        myString[0] = "YANGI OYNI KO‘RGANDA";
                        myString[1] =  R.drawable.oychiqqanda2 + "";
                        myString[2] =  "Tolha ibn Ubaydulloh roziyallohu anhudan rivoyat qilinadi:\n" +
                                "«Rasululloh sollallohu alayhi va sallam hilolni ko‘rgan vaqtlarida shunday der edilar:\n";
                        myString[3] =  "اللَّهُ أَكْبَرُ، اللَّهُمَّ أَهِلَّهُ عَلَيْنَا بِالْأَمْنِ وَالْإِيمَانِ، وَالسَّلاَمَةِ وَالْإِسْلاَمِ، وَالتَّوْفِيقِ لِمَا تُحِبُّ رَبَّنَا وَتَرْضَى، رَبُّنَا وَرَبُّكَ اللَّهُ";
                        myString[4] =  "Termiziy 3451";
                        myString[5] =  R.raw.dua175+ "";
                        myString[6] = "Allbhumma ahillahu ‘alayna bi-l-yumni va-l-ymani va-s-salymati va-l-islam. Robby va-robbuka-llbh";
                        myString[7] = "Allohim, bu oy omonlik, iymon, salomatlik, islom bilan ziynatlangai kunlar va kechalarda to‘lishsin. Ey hilol, mening ham, sening ham Robbimiz Alloxdir";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yomg‘ir so'rash duosi":{
                        String []myString = new String[8];
                        myString[0] = "YOMG‘IR SO'RASH DUOSI";
                        myString[1] =  R.drawable.yomgir2 + "";
                        myString[2] =  "Istisqo-Alloh taolodan yomg‘ir tilab o‘qiladigan duolar:";
                        myString[3] =  "اللَّهُمَّ اسْقِنَا غَيْثاً مُغِيثاً مَرِيئاً مَرِيعاً، نَافِعاً غَيْرَ ضَارٍّ، عَاجِلاً غَيْرَ آجِلًٍ";
                        myString[4] =  "Abu Dovud 1171";
                        myString[5] =  R.raw.dua169+ "";
                        myString[6] = "Allohummasqina g'oysan mug'isan mariammari'a, nafi'an g'oyro zorrin 'ajilan g'oyro ajilin.";
                        myString[7] = "Allohim, bizni foydali, barokatli, yoqimli haloskor yomg`ir bilan siylagin, zararli, qisqa va kechisi bilan emas.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Yomg‘ir so'rash duosi 2":{
                        String []myString = new String[8];
                        myString[0] = "YOMG‘IR SO'RASH DUOSI";
                        myString[1] =  R.drawable.yomgir2 + "";
                        myString[2] =  "Istisqo-Alloh taolodan yomg‘ir tilab o‘qiladigan duolar:";
                        myString[3] =  "اللَّهُمَّ أَغِثْنَا، اللَّهُمَّ أَغِثْنَا، اللَّهُمَّ أَغِثْنَا";
                        myString[4] =  "Buxoriy 1014, Muslim 897";
                        myString[5] =  R.raw.dua170+ "";
                        myString[6] = "Allohumma ag'isna, Allohumma ag'isna, Allohumma ag'isna";
                        myString[7] = "Allohim, bizni foydali, barokatli, yoqimli haloskor yomg`ir bilan siylagin, zararli, qisqa va kechisi bilan emas.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Ta’ziya duosi":{
                        String []myString = new String[8];
                        myString[0] = "TA’ZIYA DUOSI";
                        myString[1] =  R.drawable.taziya2 + "";
                        myString[2] =  "Ta’ziya duosi:";
                        myString[3] =  "بِسْمِ اللَّهِ وَعَلَى سُنَّةِ رَسُولِ اللَّهِ";
                        myString[4] =  "Abu Dovid 3215, Axmad 5234 va 4812";
                        myString[5] =  R.raw.dua163+ "";
                        myString[6] = "Bismillahi va 'ala sunnati rosulillahi sollallohu alayhi va sallam";
                        myString[7] = "Alloh nomi bilan, Allohning rosulillahi sollallohu alayhi va sallam sunnatiga muofiq.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "O‘likni ko‘zini yumib qo‘yishda":{
                        String []myString = new String[8];
                        myString[0] = "O‘LIKNI KO‘ZINI YUMIB QO‘YISHDA";
                        myString[1] =  R.drawable.olikkozi2 + "";
                        myString[2] =  "O‘likni ko‘zini yumib qo‘yishda o‘qiladigan duo:";
                        myString[3] =  "اللَّهُمَّ اغْفِرْ لِفُلاَنٍ (بِاسْمِهِ) وَارْفَعْ دَرَجَتَهُ فِي الْمَهْدِيِّينَ، وَاخْلُفْهُ فِي عَقِبِهِ فِي الْغَابِرِينَ، وَاغْفِرْ لَنَا وَلَهُ يَا رَبَّ الْعَالَمِينَ، وَافْسَحْ لَهُ فِي قَبْرِهِ، وَنَوِّرْ لَهُ فِيهِ";
                        myString[4] =  "Muslim 920";
                        myString[5] =  R.raw.dua155+ "";
                        myString[6] = "Allohummag'firli fulanin Bismillahi varfa' darojatahu fil mahdiyyina vaxlufhu fi 'aqibixi fil, g'obirina, va g'firlana valu z Robbal 'alamina, vafsah yaahu fi qobrihi, va navvirlahu fihi";
                        myString[7] = "Ey Allohim, bularni mag'firat qilgin va to'g'ri yo'lga hidoyat qilganlar orasida uning darajasini ko'taring, ortidan ergashuvchilarni o'rniga qo'ygin, olamlarning Rabbi va bizni mag'firat qilgin, uning uchun qabrini keng qil va uni yorit!";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "O‘lim talvasasidagi insonga":{
                        String []myString = new String[8];
                        myString[0] = "O‘LIM TALVASASIDAGI INSONGA";
                        myString[1] =  R.drawable.olikkozi2 + "";
                        myString[2] =  "O‘lim talvasasida yotgan odamga talqin qilinadigan kalima:";
                        myString[3] =  "لاَ إِلَهَ إِلاَّ اللَّهُ";
                        myString[4] =  "Abu Dovud 3116";
                        myString[5] =  R.raw.dua153+ "";
                        myString[6] = "La ilaha illallohu";
                        myString[7] = "Kimning ohirgi so`zi: «Allohdan o'zga haq iloh yo'qdir» deb eslatishlik kerak bo'ladi.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Bemor ko‘rishga borilganda":{
                        String []myString = new String[8];
                        myString[0] = "BEMOR KO‘RISHGA BORILGANDA";
                        myString[1] =  R.drawable.olikkozi2 + "";
                        myString[2] =  "Bemor ko‘rish uchun borilganda o‘qiladigan duolar:";
                        myString[3] =  "لاَ بأْسَ طَهُورٌ إِنْ شَاءَ اللَّهُ";
                        myString[4] =  "Buxoriy ma'al-Fatx 10/118 №3616";
                        myString[5] =  R.raw.dua147+ "";
                        myString[6] = "Al ba'sa tohurun insha-Allohu.";
                        myString[7] = "Qayg'urmang, Alloh izni bilan shifo topasiz.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Shayton vasvasa qilganda":{
                        String []myString = new String[8];
                        myString[0] = "SHAYTON VASVASA QILGANDA";
                        myString[1] =  R.drawable.gazab2 + "";
                        myString[2] =  "Shaytondan himoya qilish uchun Allohga murojaat qiling:";
                        myString[3] =  "أَعـوذُ بِاللهِ مِنَ الشَّيْـطانِ الرَّجيـم";
                        myString[4] =  "Abu Dovud 1/203, ibn Mojar 807";
                        myString[5] =  R.raw.auzubillah+ "";
                        myString[6] = "Al ba'sa tohurun insha-Allohu.";
                        myString[7] = "Men la'natlangan shaytondan Allohga tavba qilaman!";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Azon zikrlari":{
                        String []myString = new String[8];
                        myString[0] = "AZON ZIKRLARI";
                        myString[1] =  R.drawable.azon2 + "";
                        myString[2] =  "Muazzinga qoshilib aytamiz va qo'shimcha qilib qoyamiz:";
                        myString[3] =  "لاَ حَوْلَ وَلاَ قُوَّةَ إِلاَّ بِاللَّهِ";
                        myString[4] =  "Buxoriy 611. 613, Muslim 383";
                        myString[5] =  R.raw.dua22+ "";
                        myString[6] = "Hayya alo-salati, hayya ala-l-falohi La havla vala quvvata illa billahi";
                        myString[7] = "Ibodat qilishga shoshiling, muvaffaqiyatga shoshil! Allohdan o'zga quvvat egasi yoqdir";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Azondan so'ng duo":{
                        String []myString = new String[8];
                        myString[0] = "AZONDAN SO'NG DUO";
                        myString[1] =  R.drawable.azon2 + "";
                        myString[2] =  "Azondan so'ng aytiladigan duo:";
                        myString[3] =  "اَللَّهُمَّ رَبَّ هَذِهِ الدَّعْوَةِ التَّامَّةِ وَ الصَّلاَةِ القَائِمَةِ آتِ مُحَمَّداً الْوَسِيلَةَ وَ الْفَضِيلَةَ وَ ابْعَثْهُ مَقَامًا مَحْمُودًا الَّذِي وَعَدْتَهُ";
                        myString[4] =  "Muslim 327";
                        myString[5] =  R.raw.azondansong+ "";
                        myString[6] = "Allohumma robba hazihid-da'vatit-tammah. Vas-solatil qoimah, ati Muhammadanil vasiylata val faziylah. Vab'ashu maqomam mahmudanillaziy va'adtah. Varzuqna shafa-'atahu yavmal qiyamah. Innaka la tuxliful mi'ad!";
                        myString[7] = "Ushbu komil da'vatning, hozir qoim bo'lgan namozning Parvardigori, ey Alloh! Muhammadga (s.a.v.) vasila, fazilat va baland oliy daraja ato etgin. Uni O'zing va'da qilgan maqtovli maqomda tiriltirgin. Bizga Qiyomat kunida uning shafoatini nasib et. Albatta, Sen va'daga xilof qilmassan.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Masjidga borishda":{
                        String []myString = new String[8];
                        myString[0] = "MASJIDGA BORISHDA";
                        myString[1] =  R.drawable.azon2 + "";
                        myString[2] =  "Masjidga borishda o‘qiladigan duolar:";
                        myString[3] =  "اللَّهُمَّ اجْعَلْ فِي قَلْبِي نُوراً، وَفِي لِسَانِي نُوراً، وَفِي سَمْعِي نُوراً، وَفِي بَصَرِي نُوراً، وَمِنْ فَوْقِي نُوراً، وَمِنْ تَحْتِي نُوراً، وَعَنْ يَمِينِي نُوراً، وَعَنْ شِمَالِي نُوراً، وَمِنْ أَمَامِي نُوراً، وَمِنْ خَلْفِي نُوراً، وَاجْعَلْ فِي نَفْسِي نُوراً، وَأَعْظِمْ لِي نُوراً، وَعَظِّم لِي نُوراً، وَاجْعَلْ لِي نُوراً، وَاجْعَلْنِي نُوراً، اللَّهُمَّ أَعْطِنِي نُوراً، وَاجْعَلْ فِي عَصَبِي نُوراً، وَفِي لَحْمِي نُوراً، وَفِي دَمِي نُوراً، وَفِي شَعْرِي نُوراً، وَفِي بَشَرِي نُوراً";
                        myString[4] =  "Buxoriy 6316, Muslim 763";
                        myString[5] =  R.raw.dua19 + "";
                        myString[6] = "Allohumma j'alfi qolbi nuron, va fi lisani nuron, va fi sam'i nuron, va fi basri nuron, va min favqi nuron, va min tahti nuron va 'an yajini nuron, va 'an shimali nuron, va min amali nuron, va min holfi nuron, vaj'al fi nafsi nuron, va a'zomli nuron, va 'azzimli nuron, vaj'alli nuron, vaj'alni nuron, Allohumma a'tini nuron, vaj'al fi 'asobi nuron vaxfi lahmi nuron, va fi dami nuron, va fi sha'ri nuron, va fi bashari nuron.";
                        myString[7] = "Ey Allohim, mening yuragimga nur joyla, tilimga ham nur joyla, eshitishimga nur joyla, aqlimga nur joyla, tepamdan nur ber, ostimdan nur ber, o'ng tomonimdan nur der, to'g'rimdan nur ber, ortimdan nur ber, qalbimga nur joyla, menga nurni buyuk qil, men uchun nurni katta qil, men uchun yoritgin va meni nur qilgin. Ey Allohim menga nur ato et, uni tanamga joyla, qonimga nur joyla, sochlarimga nur joyla va terimga nur joyla.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Masjidga kirishda":{
                        String []myString = new String[8];
                        myString[0] = "MASJIDGA KIRISHDA";
                        myString[1] =  R.drawable.masjidgakirishda2 + "";
                        myString[2] =  "Masjidga kirishda:";
                        myString[3] =  "أَعُوْذُ بِاللهِ الْعَظِيْمِ، وَبِوَجْهِهِ الْكَرِيْمِ، وَسُلْطَانِهِ الْقَدِيْمِ، مِنَ الشَّيْطَانِ الرَّجِيْمِ، [بِسْمِ اللهِ، وَالصَّلاَةُ] وَالسَّلاَمُ عَلَى رَسُوْلِ اللهِ اَللَّهُمَّ افْتَحْ لِيْ أَبْوَابَ رَحْمَتِكَ";
                        myString[4] =  "Abu Dovud 466";
                        myString[5] =  R.raw.dua20 + "";
                        myString[6] = "«A’uzu billahi-l-’aziym va bivajhihi-l-karym va sul-tbnihi-l-qodym mina-sh-shaytbni-r-rojym. Bismillahi, va ssalatu va ssalamu ala rasullillahi. Allbhumma-ftaxly abvaba rohmatik».";
                        myString[7] = "Ulug‘ Alloh, Uning karamli yuzi va qadimiy sultoni bi-lan toshbo‘ron qilingan shayton yomonligidan panoh tilayman. Payg‘ambarimizga salomu salovatlar bo‘lsin. Allohim, men-ga rahmat eshiklarini och.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Masjiddan chiqishda":{
                        String []myString = new String[8];
                        myString[0] = "MASJIDDAN CHIQISHDA";
                        myString[1] =  R.drawable.masjiddanchiqishda2 + "";
                        myString[2] =  "Masjiddan chiqishda:";
                        myString[3] =  "بِسْمِ اللَّهِ وَالصّلَاةُ وَالسَّلَامُ عَلَى رَسُولِ اللَّهِ، اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِك، اللَّهُمَّ اعْصِمْنِي مِنَ الشَّيْطَانِ الرَّجِيمِ";
                        myString[4] =  "Sahih Ibnu Mojar 1/129";
                        myString[5] =  R.raw.dua21 + "";
                        myString[6] = "Bismillahi vassolatu vassalu 'ala rosulillah, Allohumma inni asaluka min fazlik. Allohumma a'simni min ash shaytonirrojimi.";
                        myString[7] = "Ey Allohning rasuli, Alloh nomi bilan barakot va tinchlik tilayman, ey Allohim, men Sendan rahmatingni so'rayman, ey Allohim, meni lanati shayton o'zing saqla.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Takbiri tashriq":{
                        String []myString = new String[8];
                        myString[0] = "TAKBIRI TASHRIQ";
                        myString[1] =  R.drawable.takbiritashriq2 + "";
                        myString[2] =  "Takbiri tashriq lafzlari:";
                        myString[3] =  "اللَّهُ أَكْبَرُ، اللَّهُ أَكْبَرُ، لَا إلَهَ إلَّا اللَّهُ، وَاَللَّهُ أَكْبَرُ، اللَّهُ أَكْبَرُ، وَلِلَّهِ الْحَمْدُ";
                        myString[4] =  "Abu Abdurahmondan rivoyat qilinadi:\n" +
                                "«Aliy roziyallohu anhu arafa kuni bomdod namozidan keyin to oxirgi tashriq kunining asr namozigacha va asr namozidan keyin ham takbir aytar edilar».\n";
                        myString[5] =  R.raw.takbiritashriq + "";
                        myString[6] = "Allohu akbar, Allohu akbar, Laa ilaaha illallohu vallohu akbar, Allohu akbar va lillaahil hamd.";
                        myString[7] = "“Alloh buyukdir, Alloh buyukdir. Alloh taolodan o‘zga iloh yo‘qdir. Alloh buyukdir, Alloh buyukdir va hamd Alloh (taolo) uchundir”.\n" +
                                "\n" +
                                "Izoh: 2018 yil ushbu kalimalar musulmon taqvimi bo‘yicha Zulhijja oyining 9-kuni (Melodiy 20-avgust dushanba) chin Arafa kuni bomdod namozidan to o‘n uchinchi kunning asr namozigacha aytiladi.\n" +
                                "Oxirgi marta hayitning 4-kuni asr namozidan so‘ng aytiladi. \n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Sayyidul istig‘for":{
                        String []myString = new String[8];
                        myString[0] = "SAYYIDUL ISTIG‘FOR";
                        myString[1] =  R.drawable.takbiritashriq2 + "";
                        myString[2] =  "Rasululloh sollallohu alayhi vasallam: «Kim sayyidul istig‘for –";
                        myString[3] =  "اللَّهُمَّ أَنْتَ رَبِّي لّا إِلَهَ إِلَّا أَنْتَ، خَلَقْتَنِي وَأَنَا عَبْدُكَ، وَأَنَا عَلَى عَهْدِكَ وَوَعْدِكَ مَا اسْتَطَعْتُ، وأَعُوذُ بِكَ مِنْ شَرِّ مَا صَنَعْتُ، أَبُوءُ لَكَ بِنِعْمَتِكَ عَلَيَّ، وَأَبُوءُ بِذَنْبِي فَاغْفِرلِي فَإِنَّهُ لَا يَغْفِرُ الذُّنُوبَ إِلَّا أَنْتَ";
                        myString[4] =  "Buxoriy rivoyati";
                        myString[5] =  R.raw.saidulistigfor2 + "";
                        myString[6] = "«Allohumma anta robbiy laa ilaaha illa anta xolaqtaniy va ana ‘abduka va ana ‘ala ‘ahdika va va’dika mastato’tu a’uzu bika min sharri maa sona’tu, abu‘u laka bini’matika ‘alayya va abu‘u bizambiy fag‘firliy fainnahu laa yag‘firuz zunuba illa anta» ni kechki payt aytib, shu kuni vafot etsa, jannatga kiradi. Kim tongda aytib, shu kuni vafot etsa, unda ham jannatga kiradi», dedilar. ";
                        myString[7] = "«Allohim! Sen parvardigorimsan, Sendan boshqa iloh yo‘q. Meni Sen yaratding va men Sening qulingman. Men Senga bergan va’damda va Senga bergan ahdimda qodir bo‘lganimcha turibman. Qilgan narsalarimning yomonidan Sening noming bilan panoh tilayman. Menga ato qilgan ne’matlaringga iqror bo‘ldim. Va yana gunohlarimga ham iqror bo‘ldim. Mening gunohlarimni kechir. Chunki Sendan boshqasi gunohlarni kechira olmaydi.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Qurbonlik duosi":{
                        String []myString = new String[8];
                        myString[0] = "QURBONLIK DUOSI";
                        myString[1] =  R.drawable.qurbonlik2 + "";
                        myString[2] =  "Qurbonlik qilishdan avval quyidagicha duo qilinadi:";
                        myString[3] =  "بسمِ اللَّه ان صّلوتِى وَنُسُكِى وَمَحْياىَ ومَمَاتِى لله رَب العالَمِينَ لا شَرِكَ لَهُ اللهمَّ تقَبّلْ هٰذه الأضحية\n" +
                                "\n" +
                                "بسم الله الله اكبر اللهم هذا منك ولك اللهم تقبل هذه الأضحية مني  \n";
                        myString[4] =  "Imkoni bor erkaklar qilayotgan qurbonligini o‘zi yuqorida ko‘rsatilgan duo bilan bo‘g‘izlab bergani afzal. Bo‘lmasa so‘yish vaqti, qilayotgan qurbonligini oyog‘i yoki boshqa eridan ushlab turishlari kerak, ayollar ham imkon qilishsa so‘yayotgan qurbonligi yonida hozir bo‘lib turganlari yaxshi. Chunki birinchi qatra qonini erga to‘kilishi bilan barcha qilgan gunohlari kechirilishi haqida xabarlar bor.";
                        myString[5] =  R.raw.qurban + "";
                        myString[6] = "“Allohumma inna solatii va nusukii va mahyaaya va mamaatii lillaaxi robbil ‘aalamiin. Laa shariika laxh Alloohumma taqobbal haazihil uzhiyyata.\n" +
                                "\n" +
                                "Bismillahi. Alloohu akbar. Allohumma haaza minka va laka Alloohumma taqobbal haazihil uzhiyyata minnii”.\n";
                        myString[7] = " “Allohim mening namozim va ibodatim, tirikligim va o‘limligim, barcha olamning Xojasi bo‘lgan Alloh uchundir. Ul Allohning tengi va sherigi yo‘qdir Allohim bu Qurbonni qabul ayla.\n" +
                                "\n" +
                                "Allohning nomi bilan. Alloh ulug‘dir. Allohim bu sendan va sening uchundir. Allohim bu Qurbonni mendan qabul etgin!”\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "\n" +
                                "QURBONLIK FAZILATI VA UNGA OID MASALALAR\n" +
                                "\n" +
                                "    Har yili zulhijja oyi kirib kelar ekan o‘ziga to‘q kishilar Allohga qurbat hosil qilish maqsadida va U ato etgan behisob ne’matlarga shukronalik hissining bir ramzi o‘laroq qurbonlik so‘yib, qon chiqarish uchun sog‘lom va baquvvat chorva hayvonlarini xarid qilib, to qurbon hayiti kuniga qadar boqib qo‘yadilar. \n" +
                                "    Alloh taolo uchun jonliq so‘yish dini Islomning go‘zal an’analaridan va shariatimiz buyurgan buyuk ishlardan hisoblanadi. Uning hikmat va fazilatlari beqiyosdir. Avvalo bu ish bandani Allohga yaqinlashtiradi. Shu bois ham qurbonlikni sof niyat bilan, Allohga qurbat hosil qilay, Uning roziligini topay, degan pokiza maqsadlarda amalga oshirish lozim. \n" +
                                "    Alloh taolo O‘zining cheksiz marhamati tufayli biz gunohkor bandalarni O‘ziga yaqinlashtiradigan ko‘plab sabab va vasilalarni yaratib bergan. Bu dunyoni oxiratning ekinzori qilib qo‘ygan. Dunyoda odamlar bilan muoamalada shunday holatlar bo‘ladiki, bir inson boshqa bir o‘zi hurmat qiladigan obro‘li, ziyoli yoxud badavlat insonga yaqinlashmoqchi bo‘ladi. Buning uchun turli-tuman vositalarni ishga solib ko‘radi. Unga yaxshi muoamala qiladi, iltifot ko‘rsatadi, hadiyalar beradi. Lekin, narigi odam uni umuman o‘ziga yaqinlashtirmasligi, barcha vositalar yo‘lini yopib qo‘yishi mumkin. Bu narsa hayotda ko‘p kuzatiladi. Ammo, mehribon va oliyjanob Alloh unday emas. U bizga harqancha gunoh qilsak ham, harqancha yovuz ishlarni amalga oshirgan bo‘lsak-da tavba eshigini mudom ochiq qoldiradi, O‘ziga yaqinlashtiruvchi yo‘llarni yopib qo‘ymaydi. Balki, bunday amallardan bir emas birnecha o‘nlab turini ko‘rsatib beradi. Hatto turli vosita va vasilalarni ishga solgan holda O‘ziga qurbat hosil qilishga chaqiradi. “Ey iymon keltirganlar, Allohdan qo‘rqingiz va Unga yaqin bo‘lish yo‘llarini istangiz!” (Moida surasi, 35-oyat). Oyati karimada “Unga yaqin bo‘lish yo‘llari” “vasila” so‘zi bilan ifoda qilingan. Bu dunyoda Alloh taolo bandalarini O‘ziga yaqinlashtiradigan, jannatga kiritadigan yo‘l va vasilalarni ko‘paytirib qo‘ygan. Harbir inson o‘z imkoniyati doirasida o‘zini Alloh roziligiga olib boradigan mazkur ishlarni amalga oshirishga haris bo‘lmog‘i lozim. Ota-onaga yaxshilik qilish vasila, toat-ibodatda bardavom bo‘lish vasila, sabr vasila, shukr vasila, duo vasila, istig‘for vasila, odamlarga ezgulik ulashish vasila, xayr-sadaqotlar vasila, mahzun dillarga shodlik olib kirish vasila va shularning qatorida Alloh rizosi uchun jonliq so‘yish ham bir vasiladir. Qur’oni karimda Alloh taolo Payg‘ambarimiz sollallohu alayhi va sallamni va U kishi orqali butun musulmon ummatini shu ishga buyurgan: “Bas, Rabbing uchun namoz o‘qi va jonliq so‘y!” (Kavsar surasi, 2-oyat). Mashhur tobeinlardan Qatoda, Ato va Ikrima rahmatullohi alayhimlar oyatdagi “namoz o‘qi” iborasini “hayit namozini o‘qi” deya izohlaganlar. Shunga ko‘ra, hojilar va boshqa qurbonlik qiluvchilar hayit namozi o‘talgandan so‘ng jonliqlarini so‘yadilar.\n" +
                                "\n" +
                                " \n" +
                                "Qurbonlikning ayrim hikmat va fazilatlari\n" +
                                "\n" +
                                " \n" +
                                "       Qurbonlikning hikmati va fazilatlari haqida qancha gapiriladigan bo‘lsa, shuncha oz. \n" +
                                "\n" +
                                "1. Qurbonlik – “qurbat”, ya’ni yaqinlashish so‘zi bilan o‘zakdoshdir. Bu bilan birinchi o‘rinda Allohning rahmatiga noil bo‘lish, uning marhamatiga yaqin bo‘lish maqsad qilinadi. \n" +
                                "      Alloh taolo uchun huzuridagi eng yaxshi narsani qurbon qilish inson qalbiga o‘zgacha huzur-halovat baxsh etadi. Uning orqasidan qo‘lga kiritiladigan ulkan ajru mukofot umidi kishining fikru zikrini ma’lum muddatga bo‘lsa-da, foniy dunyoning foniy moddalaridan uzib, boqiy olamning boqiy boyliklariga ko‘z tikishga undaydi. Qalbni baxillik illatidan tozalaydi. \n" +
                                "\n" +
                                "2. Bu – Allohning shiorlarini, U joriy etgan diniy marosimlarni ulug‘lash, hurmatlash demakdir. «(Ish) shudir! Kimki Allohning marosimlarini ulug‘lar (hurmatlar)ekan, bas, albatta bu (hurmat) qalblardagi taqvo tufaylidandir» (Haj surasi, 32-oyat). Demak, qurbonlik qilish qalblardagi taqvo alomati ekan. Zotan, qurbonlikning go‘shtidan ham, qonidan ham Allohga biron-bir foyda yo‘q. Balki, bu o‘zimiz uchun foydadir. \n" +
                                "\n" +
                                "3. Bayram kunida qurbonlik so‘yish xursandchilik ustiga yana bir xursandchilikdir. Bu insonning o‘ziga va ahli oilasiga kengchilik yaratishi uchun vasiladir. Qo‘ni-qo‘shni, heshu aqrabo va yoru birodarlarga ikrom qilish, faqiru miskinlarning, shikasta dil odamlarning ko‘ngillariga shodlik olib kirish uchun eng yaxshi fursatdir. \n" +
                                "\n" +
                                "4. Taqvoga erishish. Alloh taolo aytadi: «Uning (qurbonlikning) na go‘shti va na qoni Allohga yetib borur! Balki(shu ish orqali) sizlardan paydo bo‘lgan taqvogina Unga yetur» (Haj surasi, 37-oyat). \n" +
                                "\n" +
                                "5. Qurbonlik Alloh taologa U Zot ato etgan hisobsiz ne’matlari uchun shukr qilishning bir ko‘rinishidir. Darhaqiqat, Alloh taolo bani basharga sanab adog‘iga yetib bo‘lmaydigan darajada beadad ne’matlar ato etdi. Unga hayot berdi, xilqatini chiroyli qildi, sihat-salomatlik berdi, his-tuyg‘ularini bayon etishi uchun til, yorug‘ dunyoni ko‘rishi uchun ikki ko‘z, oqni qoradan ajratishi uchun aql berdi. Boylik, molu davlat berdi. Iymonu islom ne’matiga muyassar etdi. Bularning bari shukr qilishni vojib qiluvchi buyuk ne’matlardir. Qurbonlik ana shu ne’matlarning ojizona bir shukronasi o‘laroq banda tomonidan amalga oshiriladigan ishdir. \n" +
                                "\n" +
                                "6. Quyidagi hadis ham Alloh taolo uchun qurbonlik so‘yishning nechog‘lik fazilatli ekaniga dalolat qiladi. Oisha onamiz raziyallohu anhodan rivoyat: Rasululloh sollallohu alayhi vasallam marhamat qilib dedilar: «Odam bolasi Nahr kunida qon chiqarishdan ham ko‘ra Allohga mahbubroq bo‘lgan biron amalni qilmaydi.(Alloh taolo uchun so‘yilgan) jonliq qiyomat kunida shoxlari, yunglari va tuyoqlari bilan keladi. Qasamki, uning qoni hali yerga to‘kilmasdan burun Alloh huzuridagi yuksak maqomga tushadi (ya’ni hali uning qoni yerga tushmasdan bu amalning savobi Alloh huzurida yuksak o‘ringa yozib qo‘yiladi, vallohu a’lam). Bas, qilayotgan qurbonligingiz bilan shodlaning. Dimog‘ingiz chog‘ bo‘lsin!» (Termiziy rivoyati).\n" +
                                "\n" +
                                " \n" +
                                "\n" +
                                "Qurbonlikning ta’rifi\n" +
                                "\n" +
                                "       Fuqaholar qurbonlikni bir-biriga yaqin bo‘lgan bir necha xil ta’riflar bilan tanishtirganlar. Jumladan: \n" +
                                "\n" +
                                "1. “Maxsus jonivorni maxsus vaqtda so‘ymoq, u vaqt esa azho kunidir” (“al-’inoya sharhu-l-hidoya”: 9/505). \n" +
                                "\n" +
                                "2. “(qurbonlik) shar’an: maxsus hayvonni maxsus vaqtda qurbat niyati bilan so‘ymoqdir” (Haskafiy: “ad-durr al-muxtor”).\n" +
                                "\n" +
                                " \n" +
                                "\n" +
                                "Qurbonlikning hukmi\n" +
                                "\n" +
                                "      Hanafiy mazhabiga ko‘ra moli nisobga yetgan, muqim (ya’ni safarda bo‘lmagan), musulmon odam uchun qurbonlik qilish vojib hisoblanadi. Qurbonlikning vojibligiga Qur’oni karimdan yuqorida zikr qilingan Kavsar surasining 2-oyati dalil bo‘ladi. Hadisi shariflardan esa Abu Hurayra raziyallohu anhudan rivoyat qilingan quyidagi hadis dalildir. “Kimki, imkoni bo‘laturib qurbonlik qilmasa, bas, bizning namozgohimizga yaqinlashmasin” (Imom Ahmad, Ibn Moja va Hokim rivoyatlari).\n" +
                                "\n" +
                                "Qanday hayvonlarni qurbonlik qilish mumkin? \n" +
                                "\n" +
                                "       Qurbonlik uchun chorva hayvonlari so‘yiladi. Ular: tuya, sigir va qo‘ydir. Bunda ularning erkak va urg‘ochi jinslari tushuniladi. Qo‘y deganda echkilar ham nazarda tutiladi. Demak, tuya, sigir, qo‘y va echkilar qurbonlikka yaroqli hayvonlar hisoblanadi. \n" +
                                "\n" +
                                "Qurbonlik qilinadigan hayvonning shartlari \n" +
                                "\n" +
                                "\n" +
                                "     Qurbonlik qilinadigan jonliq ma’lum shartlarga javob berishi kerak. Aks holda qurbonlik durust bo‘lmaydi. Quyida ana shular haqida qisqacha to‘xtalib o‘tamiz.\n" +
                                "\n" +
                                " 1. Jonliqning yoshi qurbonlik uchun so‘yiladigan jonivor qurbonlik yoshiga yetgan bo‘lishi shart. Jobir raziyallohu anhudan rivoyat qilingan hadisda Rasululloh sollallohu alayhi vasallam shunday dedilar: «Faqat musinnani so‘yinglar. Illo, agar bu ish sizlarga qiyin kelsa, qo‘ydan jaza’ bo‘lganini so‘ysangiz ham bo‘laveradi» (Muslim rivoyatlari). «Musinna» deb tuya, mol, qo‘y va echkilardan «saniy» yoshiga to‘lganlariga aytiladi. «Saniy» umrining ikkinchi bosqichiga o‘tgan – o‘rta yoshli degani bo‘lib, u «jaza’» yoshidan keyingi bosqichdir. \n" +
                                "    Tilshunos olimlarning ta’kidlashlaricha, bo‘taloq besh yoshga to‘lib, oltiga ketganda “saniyya” deb ataluvchi old tishlari to‘kilar ekan. Ana shunda “saniy” bo‘lar ekan. Yuqoridagi hadisga binoan, tuya, sigir va echkidan faqat \"saniy\" va undan yuqori\n" +
                                "\n" +
                                "yoshda bo‘lganlarigina qurbonlikka yaroqli hisoblanadi. Qo‘ydan esa \"jaza’\" va undan yuqorisi qurbonlikka o‘tadi. Demak, tuyaning \"saniy\"si deb tug‘ilganiga besh yil to‘lgani aytiladi. Sigir va buqaning \"saniy\"si esa tug‘ilganiga ikki yil to‘lgani bo‘ladi. Qo‘y va echki esa bir yilda «saniy» bo‘ladi. Qo‘ydan \"jaza’\" bo‘lgani tug‘ilganiga olti oy to‘lib, yettinchi oy ketganidir.\n" +
                                "\n" +
                                " \n" +
                                "2. Jonliq qurbonlikning durust bo‘lishiga mone’lik qiluvchi ayblardan salomat bo‘lishi kerak.\n" +
                                "\n" +
                                "\n" +
                                "    Modomiki, qurbonlik Alloh taologa yaqinlik hosil qilish maqsadida amalga oshiriladigan ish deb e’tibor qilinar ekan, bu ish uchun eng yaxshi, eng sara, semiz, sog‘lom va aybu nuqsonlardan xoli bo‘lgan jonivorni tanlab olish maqsadga muvofiqdir. Shuningdek, qurbonlik uchun so‘yiladigan jonivor albatta halolu pokiza moldan bo‘lishi kerak. Zero, Alloh taolo xush va pokizadir, faqat xush va pokiza narsalarnigina qabul qilgay. \n" +
                                "    Baro ibn Ozib raziyallohu anhudan rivoyat qilingan hadisda Nabiy sollallohu alayhi vasallam shunday dedilar: \"To‘rt xil jonivor qurbonlikka yaramaydi: 1. Shapko‘rligi bilinib turgan darajadagi shapko‘r jonivor. 2. Kasalligi bilinib turadigan darajadagi kasal jonivor. 3. Oqsoqligi bilinib turadigan darajadagi oqsoq jonivor. 4. Oyoqda turolmaydigan darajadagi behol-madorsiz jonivor\" (Sunan sohiblari rivoyat qilishgan). Ushbu hadis qurbonlikka putur yetkazuvchi ayb-nuqsonlarni bilishda asos kabidir. Yuqoridagi hadisga binoan va qiyosan ulamolar quyidagi sifatga ega bo‘lgan jonivorlarning qurbonlikka yaramasligini aytadilar. \n" +
                                "\n" +
                                "1. Shapko‘r jonivor. \n" +
                                "2. Ko‘zi ko‘r jonivor. \n" +
                                "3. Oqsoqligi bilinib turadigan darajada oqsoq jonivor. \n" +
                                "4. Bir oyog‘i kesilgan jonivor. \n" +
                                "5. Kasalligi ko‘rinib turgan kasal jonivor. Qo‘tir bo‘lgan yoki badaniga yara toshgan jonivor ham shu jumladandir. Chunki, bunday kasalliklar jonivorning xilqatiga ta’sir qiladi, semirishiga yo‘l qo‘ymaydi. \n" +
                                "6. Oyoqda turolmaydigan darajada qiltomoq bo‘lib qolgan, majolsiz jonivor. \n" +
                                "7. Qulog‘ining hammasi yoki bir qismi kesilgan jonivor. \n" +
                                "8. Qulog‘i teshilgan yoki quloq suprasi o‘rtasidan kesilib, yoriq paydo qilingan jonivor. \n" +
                                "9. Belgi uchun qulog‘i teshib qo‘yilgan jonivor. \n" +
                                "10. Shohi kesib yoki sug‘urib olingan jonivor. Ammo o‘zi shohsiz tug‘ilgan bo‘lsa, qurbonlikka yaraydi. \n" +
                                "11. Burni kesib olingan jonivor. \n" +
                                "12. Dumi kesib tashlangan jonivor. Ammo o‘zi dumsiz yaratilgan bo‘lsa, uni qurbonlik qilish joiz, garchi ayrim ulamolar buni nojoiz sanagan bo‘lsalar ham. \n" +
                                "13. Dumbasi kesib olingan jonivor. \n" +
                                "\n" +
                                "\n" +
                                "    Xulosa qilib aytadigan bo‘lsak, qurbonlikka so‘yiladigan jonivor o‘ziga ozor yetkazadigan, semirib yog‘ boylashiga mone’lik qiladigan va bahosini tushiradigan barcha ayb-nuqson va kasalliklardan xoli bo‘lishi kerak. Salafi solihlardan naql qilinganki, ular qurbonlikka so‘yiladigan jonivorning har qanday kattayu-kichik ayblardan xoli bo‘lganini tanlar edilar. Agar jonivorda bironta arzimas ayb topilsa ham, uni qurbonlik qilishni karih ko‘rardilar.\n" +
                                "\n" +
                                " Qurbonlik vaqti \n" +
                                "\n" +
                                "     Qurbonlik so‘yishning birinchi vaqti hayit namozi bilan xutba o‘qilgandan so‘ng boshlanadi va hayitning uchinchi kuni quyosh botganda tugaydi. Boshqacharoq ibora bilan aytilsa, qurbonlik uch kun davomida so‘yiladi: qurbon hayiti kuni va uning keyinidan keluvchi tashriq kunlarining ilk ikki kunida. Biroq eng afzali qurbonlikning hayit namozi o‘qib bo‘linishi bilan amalga oshirilishidir. \n" +
                                "     Hayit namozidan avval yoki qurbonlikning oxirgi vaqtidan keyin so‘yilgan jonliq shar’iy qurbonlikka o‘tmaydi. Bunga yuqorida aytib o‘tilgan mana bu hadis dalolat qiladi. \n" +
                                "     Baro raziyallohu anhudan rivoyat qilinadi: Rasululloh sollallohu alayhi vasallam qurbonlik kuni hayit namozidan so‘ng bizlarga va’z qila turib shunday dedilar:«Bugungi kunimizda birinchi bo‘lib qiladigan amalimiz(hayit) namozni o‘qishimiz, so‘ngra (uyga) qaytib jonliq so‘yishimizdir. Kimki shunday qilsa, uning ishi sunnatga muvofiq kelibdi. Kimki namozdan avval so‘ygan bo‘lsa, u bor-yo‘g‘i oilasiga taqdim qilgan go‘shtdir, xolos. Bu kunning marosimidan (ya’ni qurbonlikdan) emas». \n" +
                                "     Imom Abu Hanifa (rahmatullohi alayh)ning fikrlariga ko‘ra qurbonlik vaqti hayit namozi o‘qilmaydigan chekka va qishloq joylar aholisi uchun quyosh chiqqandan keyin kiradi. (Ya’ni, ular bomdoddan so‘ng bir muddat o‘tib, quyosh chiqqandan keyin so‘yaversalar bo‘ladi). Ammo, hayit namozi o‘qiladigan shahar joylarda esa hayit namozi va xutbasi o‘qilgandan keyingina qurbonlik vaqti kiradi. Ungacha so‘yilgan jonliq qurbonlikka o‘tmaydi.\n" +
                                "\n" +
                                "Qurbonlikka oid ayrim masalalar \n" +
                                "\n" +
                                "1. Qurbonlik qilishda ishtirok etish \n" +
                                "\n" +
                                "Tuya va sigirni qurbonlik qilishda yetti kishi ishtirok etishi joiz. Ya’ni, masalan, yetti kishi teng pul tashlab tuya yoki sigir sotib olishadi va uni o‘z nomlaridan so‘yishadi. Shunda hammalari qurbonlik qilgan bo‘ladilar. Jobir raziyallohu anhudan rivoyat: «Biz Hudaybiya yilida Rasululloh sollallohu alayhi vasallam bilan birgalikda qurbonlik qildik. Shunda tuyani yetti kishidan, sigirni ham yetti kishidan qurbonlik qildik» (Imom Muslim rivoyati). \n" +
                                "Huzayfa raziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallam hajjatul-vadodagi qurbonlikda sigirga yetti kishini sherik qilib so‘ydirdilar» (Imom Ahmad rivoyati). Ammo qo‘y va echkilarda esa sherikchilik mumkin emas. Bitta qo‘yni faqat bir kishi so‘yishi mumkin. \n" +
                                "\n" +
                                "2. Qurbonlik qilishga qodir odam jonliq so‘ygani afzalmi yoki uning bahosini sadaqa qilgani afzalmi? \n" +
                                "\n" +
                                "Hanafiy mazhabi ulamolari pulini sadaqa qilgandan ko‘ra qurbonlik qilish afzalligini ta’kidlaydilar. Bu masalada ko‘pchilik ahli ilmlar mazhabimizdagi qavlga qo‘shiladilar. \n" +
                                "\n" +
                                "3. Qurbonlikdan foydalanish va uning taqsimoti \n" +
                                "\n" +
                                "Inson o‘zi amalga oshirgan qurbonligidan yeyishi joiz. Hanafiy (shuningdek hanbaliy) mazhabi ulamolarning so‘zlariga ko‘ra, qurbonlikning go‘shti uch qismga bo‘linadi. Uchdan biridan uning sohibi yeydi, yana uchdan birini faqir-miskinlarga sadaqa sifatida ulashadi, qolgan uchdan birini esa qarindosh-urug‘, yor-birodarlarga hadya qiladi. Biroq, agar qurbonlik egasi qurbonlikning uchdan biridan ko‘proq miqdorda iste’mol qilsa, bu ham joizdir. \n" +
                                "\n" +
                                "4. Qurbonlikni birovga so‘ydirish \n" +
                                "\n" +
                                "Qurbonlik toat bo‘lganligi uchun uni insonning o‘zi so‘ymog‘i afzal hisoblanadi. Lekin, birovni o‘zidan vakil qilib, so‘ydirishi mumkin. Bu holatda hech bo‘lmaganda o‘sha qurbonligi so‘yilayotgan mahalda uning tepasida turib, guvoh bo‘lishi maqsadga muvofiqdir.\n" +
                                "\n" +
                                " \n" +
                                "\n" +
                                "Odilxon qori Yunusxon o‘g‘li \n" +
                                "Toshkent shahar Shoyxontohur tuman bosh imom - xatibi, \"Shayx Zayniddin\" jome’ masjidi imom-xatibi\n" +
                                "\n";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Saxarlik duosi":{
                        String []myString = new String[8];
                        myString[0] = "SAXARLIK DUOSI";
                        myString[1] =  R.drawable.ramazon2 + "";
                        myString[2] =  "Ramazon oyida saxarlik duosi:";
                        myString[3] =  "نَوَيْتُ أَنْ أَصُومَ صَوْمَ شَهْرِ رَمَضَانَ مِنَ الْفَجْرِ إِلَى الْمَغْرِبِ خالصا لِلَّهِ تَعَالَى اللهُ أَكْبَرُ";
                        myString[4] =  "...";
                        myString[5] =  R.raw.saxarlikduosi + "";
                        myString[6] = "Navaytu an asuma sovma shahri ramazona minal fajri ilal mag‘ribi, xolisan lillahi ta’ala. Allohu akbar!";
                        myString[7] = "Ramazon oyining ro‘zasini subxdan to kun botguncha tutmoqni niyat qildim. Xolis Allox uchun. Allox Buyukdir.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Iftorlik duosi":{
                        String []myString = new String[8];
                        myString[0] = "SAXARLIK DUOSI";
                        myString[1] =  R.drawable.ramazon2 + "";
                        myString[2] =  "Ramazon oyida iftorlik duosi:";
                        myString[3] =  "اللَّهُمَّ لَكَ صُمْتُ، وَبِكَ آمَنْتُ، وَعَلَيْكَ تَوَكَّلْتُ، وَعَلَى رِزْقِكَ أَفْطَرْتُ فَاغْفِرْ لِي مَا قَدَّمْتُ وَمَا أَخَّرْتُ";
                        myString[4] =  "...";
                        myString[5] =  R.raw.ramazoniftor + "";
                        myString[6] = "Allohumma laka sumtu va bika amantu va a’layka tavakkaltu va ‘ala rizqika aftartu, fag‘firli yaya g‘offaru ma qoddamtu va ma axxortu.";
                        myString[7] = "Ey Allox, ushbu Ro‘zamni Sen uchun tutdim va Senga iymon keltirdim va Senga tavakal qildim, va bergan rizqing bilan iftor qildim. Ey gunoxlarni afv qilguvchi Zot, mening avvalgi va keyingi gunoxlarimni mag‘firat qilgil.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Tashahhudning oxirida":{
                        String []myString = new String[8];
                        myString[0] = "TASHAHHUDNING OXIRIDA";
                        myString[1] =  R.drawable.tashahhud + "";
                        myString[2] =  "Tashahhudning oxirida salom berishdan oldin aytiladigan duo: ";
                        myString[3] =  "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عَذَابِ جَهَنَّمَ ، وَمِنْ عَذَابِ الْقَبْرِ ، وَمِنْ فِتْنَةِ الْمَحْيَا وَالْمَمَاتِ ، وَمِنْ شَرِّ فِتْنَةِ الْمَسِيحِ الدَّجَّالِ";
                        myString[4] =  "Muslim rivoyati";
                        myString[5] =  R.raw.tashahhud + "";
                        myString[6] = "Allohumma inniy a’uzu bika min ‘azabi jahannama va min ‘azabil qobri va min fitnatil mahya val mamaati va min sharri fitnatil masiyhid dajjaal";
                        myString[7] = "Abu Hurayra roziyallohu anhudan rivoyat qilinadi: «Rasululloh sollallohu alayhi vasallam: «Agar birortangiz (oxirgi) tashahhudni o‘qib bo‘lsa, to‘rtta narsadan panoh so‘rasin: jahannam azobidan, qabr azobidan, hayot va o‘lim fitnasidan, Masiyh Dajjolning yomonligidan», deb aytdilar»";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    case "Majlisning kafforoti":{
                        String []myString = new String[8];
                        myString[0] = "MAJLISNING KAFFOROTI";
                        myString[1] =  R.drawable.majlis + "";
                        myString[2] =  "Abu Hurayra roziyallohu anhudan rivoyat qilinadi:\n" +
                                "Rasululloh sollallohu alayhi vasallam: «Kim majlisda o‘tirganida befoyda so‘zlari ko‘payib ketsa: \n";
                        myString[3] =  "سبحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ أَشْهَدُ أَنْ لا إِلهَ إِلأَ انْتَ أَسْتَغْفِرُكَ وَأَتْوبُ إِلَيْكَ";
                        myString[4] =  "Imom Termiziy rivoyat qilib, hasan, sahih dedilar.";
                        myString[5] =  R.raw.majlisning_kafforoti + "";
                        myString[6] = "«Subhanakallohumma va bihamdika ashhadu alla ilaha illa anta astag‘furuka va atubu ilayka», \n" +
                                "deb aytsa, ana shu majlisda sodir bo‘lgan narsalari kechiriladi», dedilar.\n";
                        myString[7] = "Allohim, Senga hamd aytish ila Seni poklab yod etaman. Guvohlik beramanki, Sendan boshqa iloh yo‘q. Senga istig‘for aytib, tavba qilaman.";
                        Intent intent = new Intent(context,IndudualDuo.class);
                        intent.putExtra("myString",myString);
                        context.startActivity(intent);
                        break;}
                    default:{
                        break;
                    }

                }
            }else {

                //for (Item it : lovedItems) {
                Item it = lovedItems.get(position);
                  //  if (position + 1 == it.id) {
//                       it.isFavour = true;
//                       dao.updateItem(it);
                            updateUI(it);

                        lovedItems.clear();
               lovedItems = ((App)context.getApplicationContext()).getItemDB().loadItemDao().loadUnlikeds(0);
                        // viewHolder.onBind(items.get(position));

                   // }
               // }
            }
        }
        private void updateUI(Item item){
            for (Item it : lovedItems) {
                if (it.text.equals(item.text)){
                    it.isFavour = 1;
                    dao.updateItem(it);
                    break;
                }
            }
//            item.isFavour = 1;
//            dao.updateItem(item);
//            String text = item.text;
//            int isFavor = 1;
//            int imgRes = item.imgRes;
//            for (Item it: lovedItems) {
//                if (it.isFavour == 0 ){
//                    item.isFavour = it.isFavour;
//                    item.text = it.text;
//                    item.imgRes = it.imgRes;
//                    dao.updateItem(item);
//                    it.isFavour = isFavor;
//                    Toast.makeText(context, ""+lovedItems.size(), Toast.LENGTH_SHORT).show();
//                    it.text = text;
//                    it.imgRes = imgRes;
//                    dao.updateItem(it);
////                    notifyAll();
//                    break;
//                }
//            }
        }
//        private void antiUpdateUI(Item item){
//            String text = item.text;
//            int isFavor = 0;
//            int imgRes = item.imgRes;
//            for (int i = lovedItems.size()-1; i >=0; i--) {
//                Item it = lovedItems.get(i);
//                if (it.isFavour  == 1){
//                    if (item.id == it.id){
//
//                    }else {
//                        item.isFavour = 1;
//                        item.text = it.text;
//                        item.imgRes = it.imgRes;
//                        dao.updateItem(item);
//                    }
//                    it.isFavour = isFavor;
//                    it.text = text;
//                    it.imgRes = imgRes;
//                    dao.updateItem(it);
//                    break;
//                }
//            }
//        }
        private void initDB() {

            dao = itemDB.loadItemDao();
            lovedItems = dao.loadUnlikeds(0);
            //items = dao.loadAllItems();
//            for (Item it : dao.loadAllItems()) {
//                if (dao.loadAllItems().size() >= 1 && it.isFavour){
//                    lovedItems.add(it);
//                }
//            }
        }
    }
}