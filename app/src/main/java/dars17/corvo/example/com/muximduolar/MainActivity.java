package dars17.corvo.example.com.muximduolar;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;

import dars17.corvo.example.com.muximduolar.adapter.ItemAdapter;
import dars17.corvo.example.com.muximduolar.adapter.PagerAdapter;
import dars17.corvo.example.com.muximduolar.db.Item;
import dars17.corvo.example.com.muximduolar.db.ItemDAO;
import dars17.corvo.example.com.muximduolar.db.ItemDB;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    public static final String KEY = "myPrefereceKey";
    public  ItemDAO dao;
    public ItemDB dataBase;
    private Toolbar toolbar;
   // private RecyclerView rv;
    private ViewPager viewPager;
    private TabLayout tabLayout;
   // private ItemAdapter adapter;
    private App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = (App) getApplication();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        initDB();
        super.onStart();
        SharedPreferences settings = getSharedPreferences(KEY, MODE_PRIVATE);
        initViews();
        String value = settings.getString("key2", "");
        if (!(value.equals("true"))) {
            MyTask task = new MyTask();
            task.execute();
            SharedPreferences.Editor editor2 = settings.edit();
            editor2.putString("key2", "true");
            editor2.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.dastur_haqida) {
            startActivity(new Intent(this, DasturHaqida.class));
        } else {
            Intent boshqaDasturlar = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Islam+Apps+World"));
            startActivity(boshqaDasturlar);

        }

        return super.onOptionsItemSelected(item);
    }
    private void initViews() {
     //   rv = findViewById(R.id.rv);
        viewPager = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tabLayout);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


       // adapter = new ItemAdapter(this, dataBase);
        app.setItemDB(dataBase);
      //  rv.setAdapter(adapter);
//        Disposable d = dao.loadAll()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<Item>>() {
//                    @Override
//                    public void accept(List<Item> items) {
//
//                        adapter.submitList(items);
//                    }
//                });
    }

    private void initDB() {
        dataBase = Room.databaseBuilder(this,
                ItemDB.class, "database3")
                .allowMainThreadQueries()
                .build();
        dao = dataBase.loadItemDao();
        app.setItemDB(dataBase);
    }


    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            int imageId[] = new int[86];
            String[] numbers = {
                    "Tonggi duo",
                    "Tonggi duo 2",
                    "Tonggi zikir",
                    "Tonggi zikir 2",
                    "Kechggi duo",
                    "Tonggi va kechgi",
                    "Tonggi va kechgi 2",
                    "Tonggi va kechgi 3",
                    "Uxlashdan avval",
                    "Uxlashdan avval 2",
                    "Uyqusida cho'chiganda",
                    "Yomon tush ko'rganda",
                    "Uyqudan uyg`onganda",
                    "Uyqudan uyg`onganda 2",
                    "Uyqudan uyg`onganda 3",
                    "Yomg‘ir yog‘ayotganda",
                    "Kiyim kiyishda",
                    "Kiyim yechishda",
                    "Yangi kiyim kiyganda",
                    "Yangi kiyim kiyganda 2",
                    "Taomlangandan avval",
                    "Taomlangandan avval 2",
                    "Taomlangandan so‘ng",
                    "Taomlangandan so‘ng 2",
                    "Xojatxonaga kirishda",
                    "Xojatxonadan chiqishda",
                    "Tahorat olishdan avval",
                    "Tahorat olib bo‘lgach",
                    "Tahorat olib bo‘lgach 2",
                    "Tahorat olib bo‘lgach 3",
                    "Uydan chiqishda",
                    "Uydan chiqishda 2",
                    "Uyga kirishda",
                    "Manzilga yetganda",
                    "Ot-ulovga minilganda",
                    "Ot-ulovga minilganda 2",
                    "Safarga chiqishdagi duo",
                    "Safardan qaytgandagi zikr",
                    "Bemorga o‘qiladigan duo",
                    "Bemorga o‘qiladigan duo 2",
                    "Qayg‘u-g‘amda o‘qiladigan",
                    "Qayg‘u-g‘amda o‘qiladigan 2",
                    "Qayg‘u-g‘amda o‘qiladigan 3",
                    "Balodan saqlovchi duo",
                    "Musibat yetgan kishi duosi",
                    "Musibatli kishini ko'rganda",
                    "Ishi og‘irlashganda aytiladi",
                    "Qarzni to‘lashda o‘qiladi",
                    "Qarzni to‘lashda o‘qiladi 2",
                    "Qarzni to‘lashda o‘qiladi 3",
                    "Qur’oniy duo",
                    "Qur’oniy duo 2",
                    "Qur’oniy duo 3",
                    "Qur’oniy duo 4",
                    "Sunnatda kelgan duo",
                    "Sunnatda kelgan duo 2",
                    "Sunnatda kelgan duo 3",
                    "Panoh so‘rash duosi",
                    "Mehmonning mezbonga duosi",
                    "Shar’iy qo‘shilish duosi",
                    "Bozorga kirishda",
                    "Sizga yaxshilik qilganga duo",
                    "G‘azablanganda o‘qiladigan duo",
                    "Shayton vasvasa qilganda",
                    "Aksirganda o‘qiladigan duo",
                    "Yangi oyni ko‘rganda",
                    "Yomg‘ir so'rash duosi",
                    "Yomg‘ir so'rash duosi 2",
                    "Azon zikrlari",
                    "Azondan so'ng duo",
                    "Masjidga borishda",
                    "Masjidga kirishda",
                    "Masjiddan chiqishda",
                    "Takbiri tashriq",
                    "Sayyidul istig‘for",
                    "Qurbonlik duosi",
                    "Saxarlik duosi",
                    "Iftorlik duosi",
                    "Bemor ko‘rishga borilganda",
                    "O‘lim talvasasidagi insonga",
                    "O‘likni ko‘zini yumib qo‘yishda",
                    "Ta’ziya duosi",
                    "Janoza namozida o‘qiladi",
                    "Qabristonga borganda",
                    "Tashahhudning oxirida",
                    "Majlisning kafforoti"};
            imageId[0] = R.drawable.tongiduo;
            imageId[1] = R.drawable.tongiduo;
            imageId[2] = R.drawable.tongiduo;
            imageId[3] = R.drawable.tongiduo;
            imageId[4] = R.drawable.kechgiduo;
            imageId[5] = R.drawable.tongvakechgiduo;
            imageId[6] = R.drawable.tongvakechgiduo;
            imageId[7] = R.drawable.tongvakechgiduo;
            imageId[8] = R.drawable.uxlashdan_avval;
            imageId[9] = R.drawable.uxlashdan_avval;
            imageId[10] = R.drawable.uyqusida_chochiganda;
            imageId[11] = R.drawable.yomon_tush;
            imageId[12] = R.drawable.uyqudan_uygonganda;
            imageId[13] = R.drawable.uyqudan_uygonganda;
            imageId[14] = R.drawable.uyqudan_uygonganda;
            imageId[15] = R.drawable.yomgiryogganda;
            imageId[16] = R.drawable.kiyim_kiyishda;
            imageId[17] = R.drawable.kiyim_yechishda;
            imageId[18] = R.drawable.yangi_kiyim_kiyganda;
            imageId[19] = R.drawable.yangi_kiyim_kiyganda;
            imageId[20] = R.drawable.ovqatdanoldin;
            imageId[21] = R.drawable.ovqatdanoldin;
            imageId[22] = R.drawable.ovqatdansong;
            imageId[23] = R.drawable.ovqatdansong;
            imageId[24] = R.drawable.xojatxonaga_kirish;
            imageId[25] = R.drawable.xojatxonadan_chiqish;
            imageId[26] = R.drawable.tahoratolish;
            imageId[27] = R.drawable.taxoratdansong;
            imageId[28] = R.drawable.taxoratdansong;
            imageId[29] = R.drawable.taxoratdansong;
            imageId[30] = R.drawable.uydan_chiqishda;
            imageId[31] = R.drawable.uydan_chiqishda;
            imageId[32] = R.drawable.uyga_kirishda;
            imageId[33] = R.drawable.manzilga_yetganda;
            imageId[34] = R.drawable.transportga;
            imageId[35] = R.drawable.transportga;
            imageId[36] = R.drawable.safarga_chiqqanda2;
            imageId[37] = R.drawable.safardan_qaytganda2;
            imageId[38] = R.drawable.kasalkorish;
            imageId[39] = R.drawable.kasalkorish;
            imageId[40] = R.drawable.qaygugam;
            imageId[41] = R.drawable.qaygugam;
            imageId[42] = R.drawable.qaygugam;
            imageId[43] = R.drawable.balodansaqlovchi;
            imageId[44] = R.drawable.musibat;
            imageId[45] = R.drawable.balolangan;
            imageId[46] = R.drawable.ishiogirlashganda;
            imageId[47] = R.drawable.qarzdanqutulish;
            imageId[48] = R.drawable.qarzdanqutulish;
            imageId[49] = R.drawable.qarzdanqutulish;
            imageId[50] = R.drawable.quroniyduo;
            imageId[51] = R.drawable.quroniyduo;
            imageId[52] = R.drawable.quroniyduo;
            imageId[53] = R.drawable.quroniyduo;
            imageId[54] = R.drawable.quroniyduo;
            imageId[55] = R.drawable.quroniyduo;
            imageId[56] = R.drawable.quroniyduo;
            imageId[57] = R.drawable.quroniyduo;
            imageId[58] = R.drawable.mezbonnimehmonga;
            imageId[59] = R.drawable.qoshilishdanoldin;
            imageId[60] = R.drawable.bozorgakirish;
            imageId[61] = R.drawable.sizgayaxshilik;
            imageId[62] = R.drawable.gazab;
            imageId[63] = R.drawable.gazab;
            imageId[64] = R.drawable.aksurganda;
            imageId[65] = R.drawable.oychiqqanda;
            imageId[66] = R.drawable.yomgir;
            imageId[67] = R.drawable.yomgir;
            imageId[68] = R.drawable.azon;
            imageId[69] = R.drawable.azon;
            imageId[70] = R.drawable.azon;
            imageId[71] = R.drawable.masjidgakirishda;
            imageId[72] = R.drawable.masjiddanchiqishda;
            imageId[73] = R.drawable.takbiritashriq;
            imageId[74] = R.drawable.takbiritashriq;
            imageId[75] = R.drawable.qurbonlik;
            imageId[76] = R.drawable.ramazon;
            imageId[77] = R.drawable.ramazon;
            imageId[78] = R.drawable.olikkozi;
            imageId[79] = R.drawable.olikkozi;
            imageId[80] = R.drawable.olikkozi;
            imageId[81] = R.drawable.taziya;
            imageId[82] = R.drawable.janozanamozi;
            imageId[83] = R.drawable.qabriston;
            imageId[84] = R.drawable.tashahhud2;
            imageId[85] = R.drawable.majlis2;
            Item item;
            for (int i = 0; i < imageId.length; i++) {
                item = new Item();
                item.imgRes = imageId[i];
                item.text = numbers[i];
                dao.addItem(item);



            }
            return null;
        }
        }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (Const.whichPage == 2){
            Const.whichPage = 1;
            viewPager.setCurrentItem(1);
        }
    }
}