package com.example.graceunlimited;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shona extends Fragment implements View.OnClickListener {
    ListView listView;
    CustomAdapter customAdapter;
    String hymn1= "Imi mose muri pasi,<br>" +            "Imbai kuna Jehovha:<br>" +            "Kurumbidzai mumutende;<br>" +            "Uyai norufaro kwaari.<br><br>" +
            "Tinoziva kuti J’ovha<br>" +            "Ndiye Mwari wechokwadi;<br>" +            "Tiri bara rehwai dzake<br>" +            "Anotipa kudya kwedu.<br><br>" +
            "Pindai suwo guru rake;<br>" +            "Muswedere kuna Mambo;<br>" +            "Tsimutsai mazvi enyu,<br>" +            "Makafanira kudaro.<br><br>" +
            "Ndiye Mwari wakanaka,<br>" +            "Tsitsi dzake dzakakomba;<br>" +            "Rudo nechokwadi chake<br>" +            "Hachingatipinde isu<br>";
    String hymn2 =
            "Mwari muri zuva redu<br>" +                    "rinopenya pa uzuru<br>" +                    "asi mweya ungaone<br>" +                    "paunozofamba napo<br><br>" +
                    "Mwari muri nhowo yedu<br>" +                    "hatidzitye hondo dzedu<br>" +
                    "dzose dzinokundwa nemi<br>" +                    "tigouya nekufara<br><br>" +
                    "Munotipa ngoni dzenyu<br>" +                    "munotipa neutsvene<br>" +
                    "munopa vanonamata<br>" +                    "munopa makomborero<br><br>" +
                    "Makomborero makuru<br>" +                    "makomborero edenga<br>" +
                    "aripo avanofunga<br>" +                    "kuti vanodiswa nemi<br>";
    String hymn3 =
            "Ngatimukudzei Mwari<br>"+                    "Nemwoyo inofara,<br>"+                    "Tsitsi dzake ihuru<br>"+                    "dzinoitirwa isu.<br><br>" +
                    "Anorayira zuva<br>" +                    "Rivhenekera nyika,<br>" +                    "Tsitsi dzake ihuru<br>" +                    "Dzinoitirwa isu" +
                    "<br><br>Zivhu zvese zvipenyu<br>" +                    "Zvinoponeswa naye;<br>" +                    "Tsitsi dzake ihuru<br>" +                    "Dzinoitirwa isu" +
                    "<br><br>Anotikwanisawo,<br>" +                    "Anoda kukumbirwa<br>" +                    "Tsitsi dzake ihuru<br>" +                    "Dzinoitirwa isu" +
                    "<br><br>Kana tirimunhamu<br>" +                    "Tinochengetwa naye<br>" +                    "Tsitsi dzake ihuru<br>" +                    "Dzinoitirwa isu" +
                    "<br><br>Mwana wake wakafa <br>" +                    "kuti tipinde denga<br>" +                    "Tsitsi dzake ihuru <br>" +                    "dzinoitirwa isu.";
    String hymn4 =
            "Mukudzei iye Mwari,<br>" +                    "Navari  kudenga;<br> " +                    "Mukudzei iye Mwari,<br> " +                    "Navari kudenga.<br><br>" +
                    "Imi muri nhume dzake,<br>" +                    " Mukudzei iye ;<br>" +                    " Nemi muri hondo dzake,<br>" +                    " Mukudzei iye ;<br><br>" +
                    "Iwe zuva, newe mwedzi,<br>" +                    " Mukudzei iye ;<br>" +                    " Nemiwo imi nyenyedzi,<br>" +                    " Mukudzei iye ;<br><br>" +
                    "Iwe moto newe chando,<br>" +                    "Mukudzei iye ;<br>" +                    "Iwe Chando newe bute,<br>" +                    " Mukudzei iye ;<br><br>" +
                    "Nemhepo inovhuvhuta,<br>" +                    " Chimukudza iye;<br> " +                    "Newe ita inzwi rake,<br>" +                    " Paunozonzwika<br><br>" +
                    "Imi muri vase mese,<br>" +                    " Mukudzei iye; <br>" +                    "Nemi imi vanhu mese,<br>" +                    " Mukudzei iye ;<br><br>" +
                    "Imi vese vakomana,<br>" +                    " Mukudzei iye ;<br>" +                    " Nemi vasikana, <br>" +                    "Mukudzei iye ;<br><br>" +
                    "Nemi vanhu vachembera,<br>" +                    " Mukudzei iye ;<br>" +                    "Nemi imi mhuri yose,<br>" +                    " " +
                    "Mukudzei iye ;";
    String hymn5 =
            "Jehovha una masimba,<br>" +                    "zvose zvakasikwa newe;<br>" +                    "Uri Ishe wavo vose,<br>" +                    " Ivo vari pakudenga.<br><br>" +
                    "Jehovha uno ruzivo,<br>" +                    " Unoziva zvose zvinhu,<br> " +                    "Isu vanhu hatizivi, <br>" +                    "Isu tose hatigoni<br><br>" +
                    "Jehovha wakarurama,<br>" +                    " Naiyo murau yake,<br>" +                    " Isu nyamba tapfuura, <br>" +                    "Tine mhosva  mberi kwake<br><br>" +
                    "Jehovha uri Mutsvene,<br>" +                    " Takaipa mberi kwenyu;<br>" +                    " Isu ngatimukumbire,<br>" +                    " Rwose ruregerero rwake<br><br>" +
                    "Jehovha unadzo ngoni,<br>" +                    " Wotibata nadzo tose,<br>" +                    " Wakauya Mwana wenyu,<br>" +                    " Kuponesa vanhu vose.<br><br>";
    String hymn6 =
            "Wakasika zvose zvinhu,<br>" +                    "Iwe, Mwari wega,<br>" +                    " Pasina wakayamura,<br>" +                    " kuzviita kwako<br><br>" +
                    "Aya makomo amire, <br>" +                    "Akasikwa newe,<br>" +                    " Akamira akasimba,<br>" +                    " Nokutsigwa newe<br>" +
                    "<br>Nayo mvura yatinomwa,<br>" +                    " Takapiwa newe;<br>" +                    "Naiko kudya kwatinodya, <br>" +                    "Takapihwa newe<br><br>" +
                    "Wakasika vanhu iwe,<br>" +                    " Nokufana newe,<br>" +                    " Ukavapa zvinhu zvose, <br>" +                    "zvikavakodzera<br><br>" +
                    "Kwasvika muvengi wavo,<br>" +                    " Akavabvutira;<br>" +                    " Vakusiya iwe Mwari;<br>" +                    " Vakanzwa izwi rake<br><br>" +
                    "Wakati kuvaponisa,<br>" +                    " Ukaita tsitsi; <br>" +                    "Ukavapa Mwana wako,<br>" +                    " Achizovafira";
    String hymn7 =
            "Ndinoshamiswa kwazvo<br>" +
                    "Namabasa makuru<br>" +                    "Akaitiwa newe,<br>" +                    "Ose anorumbidza<br>" +                    "Ukuru hwenyu Mwari<br>" +
                    "Hunoshamisa kwazvo.<br><br>" +                    "Kana ndarangrira<br>" +                    "Mabasa okudenga,<br>" +                    "Kana ndarangira<br>" +
                    "Mabasa epanyika,<br>" +                    "Inobuda misodzi<br>" +                    "Kana ndafunga iwe.<br><br>" +                    "Mwari vatatu mumwe,<br>" +
                    "Itai kuti tikude;<br>" +                    "Nokuti wakatida,<br>" +                    "Wakazotipa Jesu,<br>" +                    "Watipa mweya wenyu<br>" +
                    "Wokutipupurira.<br><br>" +                    "Rumbidza iwe denga!<br>" +                    "Rumbidza iwe nyika!<br>" +                    "Rumbidza iwe gungwa!<br>" +
                    "Nesu ngatirumbidze!<br>" +                    "Uyu musiki wedu,<br>" +                    "Ano rudo rukuru.<br>";
    String hymn8 =
            "Zadzisa chirevo chako,<br>" +                    "Mwari, Ishe wechokwadi;<br>" +                    "Ose marudzi enyika<br>" +
                    "Ngaawane ruponiso.<br><br>" +                  "Namabvi kune’i nyika,<br>" +                    "Ngaapfugame panewe;<br>" +                    "Dzidzamare dzose ndimi<br>" +
                    "Dzireve ukuru hwako.<br><br>" +                    "Tonga, Tonga, Ishe Jesu!<br>" +                    "Kuuye newe kufara,<br>" +                    "Nezvikanganiso zvedu<br>" +                   "Tatadzisa yose nyika.<br><br>" +                    "Tarira nyika yokwedu,<br>" +
                    "Urege kuipa kwayo<br>" +                    "Urege kutsamwa kwako<br>" +
                    "Isingafe mhuri yavo.<br><br>" +                    "Ramba Ishe tisazvidze<br>" +                    "Zvidzidziso zvenzwi rako;<br>" +                    "Ugozotimutsira<br>" +
                    "Tinzwe nechokwadi chako.<br>";
    String hymn9=
            "Hosana wokudenga,<br>" + "Ndoimba nezwi rangu,<br>" + "Kumwana waDavid,<br>" + "Wauya Kwandiri,<br>" + "Hosana, ndiyamure<br>" + "Pakurema kwangu:<br>" +
                    "Wauya asadanwa<br>" +                    "Muponisi wangu.<br><br>" +                    "Ndoshonge dzakadini<br>" +                    "Azondishanyira?<br>" +
                    "Mugadziriri iwe<br>" +                    "Moyo wako wose,<br>" +                    "Ndoupira kwauri<br>" +                    "Mununuri wangu,<br>" +
                    "Upfugame namabvi<br>" +                    "Chokwadi ‘she wangu.<br><br>" +                    "Ndasunungurwa newe<br>" +                    "Mudhorongo rangu:<br>" +
                    "Rakadimurwa newe<br>" +                    "Iro joti rangu<br>" +                    "Rakandirasikisa<br>" +                    "Ndasiya upenyu<br>" +
                    "Wakandifarisazve<br>" +                    "Pakuchema kwangu.<br>";
    String hymn10 =
            "Mununuri wedu,<br> Wasvika kwatiri,<br>" +                    " Mwoyo yedu yose,<br>Ifare zvakare,<br>" +                    " Mununuri wasvikazve!<br>" +                    " Mununuri tamunzwazve<br><br>" +
                    "Tose ngatifare,<br> " +                    "Pauso hwakewo,<br>" +                    "Tidzokere kwaari,<br>" +                    "Nokudana kwake,<br>" +
                    " Mununuri wasvikazve! <br>" +                    "Mununuri tamunzwazve<br><br>" +                    "Tinodiwa naye ,<br>" +                    "Muripiri wedu;<br>" +
                    "Naye ngatifare ,<br>" +                    "Nemimwoyo yedu. <br>" +                    " Mununuri wasvikazve!<br>" +                    " Mununuri tamunzwazve<br><br>" +
                    "Anotirevera,<br> " +                    "Tsitsi dzake dzose,<br>" +                    "Anodanidzira,<br> " +                    "Mune denga rake,<br>" +
                    " Mununuri wasvikazve!<br>" +                    " Mununuri tamunzwazve<br><br>";

    String hymn11 =
            "Watakura kuipa Jesu,<br>" +                    "Kusi kuipa kwako;<br>" +                    "Ukaripa mhosva Jesu,<br>" +                    "Isi mhoswa yako.<br><br>" +
                    "Waiva munhu unetsitsi<br>" +                    "Usatadza Iwe;<br>" +                    "Raparara ropa rako,<br>" +                    "Wakanaka iwe.<br><br>" +
                    "Kudarika kwedu kwose,<br>" +                    "Kwakanyorwa newe;<br> "+                    "Nezvirandu zvedu zvose,<br>" +                    "Zvakanyorwa newe.<br><br>" +
                    "Taregerwa taponiswa,<br>" +                    "Nezvirwadzo zvako,<br>" +                    "Tinoshambwa pakaipa<br>" +                    "Nero ropa rako.<br>";
    String hymn12=
            "Tsitsi hedzi dzamira dzoga,<br>" +                    "Nezvirwadzo zvakamira zvoga,<br>" +                    "Nengoni dzakamira dzoga,<br>" +                    "Pamuchinjikwa.<br><br>" +
                    "Ishe waburuka kudenga,<br>" +                    "Akazova munhu kuvanhu,<br>" +                    "Akava diramhamba redu,<br>" +                    "Pamuchinjikwa.<br><br>" +
                    "Rutendo rwedu rwomirepi?<br>" +                    "Kufunga kwedu kwomirepi?<br>" +                    "Norudo rwedu rwomirepi<br>" +                    "Pamuchinjikwa.<br>" +
                    "<br>Tsaona ingaperi yose,<br>" +                    "Nemhaka dzose dzingaripwe;<br>" +                    "Zvakaipa zvinoregerwa;<br>" +                    "Pamuchinjikwa.<br><br>" +
                    "Dzakaona ngirozi pasi,<br>" +                    "Dzakati gwanamwana kutarisa pasi,<br>" +                    "Dzichiona mashure ayo!<br>" +                    "Pamuchinjikwa.<br><br>" ;
    String hymn13 =
            "Ngatitende kuna Jesu,<br>" +                    " Nokuti watifira;<br>" +                    " Wakatiitira tsitsi,<br>" +                    "Nokutifira kwake;<br>" +
                    "Ishe,Baba!,<br>" +                    "Iva netsitsi nesu<br><br>" +                    "Isu vanhu vamapofu,<br>" +                    " Wakauya kunesu;<br>" +
                    "Wakafira vanhu vose<br>" +                    "Wakafira mapofu <br>" +                    "Ishe,Baba!,<br>" +                    "Ivanetsitis nesu<br><br>" +
                    "Vatema naivo vachana,<br> " +                    "Vatende pamwe chete;<br>" +                    " Ngavakurumbidze vese,<br>" +                    " Vaimbe kuna Ishe;<br>" +
                    " Ishe,Baba!,<br>" +                    "Iva netsitisi nesu<br><br>";
    String hymn14 =
            "CHANGAMIRE , Muponisi<br>" +                    "Ishe wakambozvidzwa;<br>" +                    "Nezvirwadzo zvako, tenzi,<br>" +                    "Kwakwaniswa kupona.<br><br>" +
                    "Changamire, Mambo Jesu!<br>" +                    "Mutakuri wemhosva;<br>" +                    "Nako kufa kwakakomba<br>" +                    "Takapiwa kupona.<br><br>" +
                    "Gwayana raMwari baba<br>" +                    "Tonamata kwauri;<br>" +                    "Ropa rakaparadzirwa<br>" +                    "Isu vakarasika.<br>" +
                    "Vanhu vako vose, Ishe<br>" +                    "Vakatengerwa nzwimbo;<br>" +                    "Vakazarurirwa musuwo<br>" +                    "Webako rokudenga.<br><br>" +
                    "Changamire! Wakagadzwa<br>" +                    "Pachigaro chitswene,<br>" +                    "Hondo dzose dzokudenga<br>" +                    "Dzinokukurumbidza.<br>" +
                    "Unoteurira isu<br>" +                    "Unotireverera;<br>" +                    "Pamusha wako mutsvene<br>" +                    "Unoda kutipinza.<br><br>" +
                    "Wafanira kugam’chira<br>" +                    "Kukudzwa noutsvene;<br>" +                    "Kukurumbidzwa kukuru,<br>" +                    "Rudo rusingaperi.<br>" +
                    "Tiyamurei ngirozi,<br>" +                    "Uyai nenziyo dzenyu;<br>" +                    "Tose tiimbire mambo<br>" +                    "Tine mwoyo michena<br>";
    String hymn15=
            "N’anga huru yava pedyo<br>" +                    "Une tsitsi ndiJesu;<br>" +                    "Anoda kutifarisa,<br>" +                    "Inzwa izwi raJesu.<br><br>" +
                    "Korus <br>" +                    "Rwiyo rwakanakisa,<br>" +                    "Zita rakanakisa,<br>" +                    "Rumbo rwakanakisa,<br>" +
                    "Jesu, Ishe, Jesu.<br><br>" +                    "Waregerwa zvakaipa,<br>" +                    "Inzwa izwi raJesu;<br>" +
                    "Famba zvakanaka uko,<br>" +                    "Uende kuna Jesu.<br><br>" +                    "Utsvene huri kwaari,<br>" +                    "Zvino ndotenda Jesu;<br>" +
                    "Ndinorida zita rake,<br>" +                    "Zita raKristu Jesu.<br><br>" +                    "Kutya kwangu kwaparadzwa,<br>" +                    "Nero zita raJesu.<br>" +
                    "Mwoyo wangu unofara<br>" +                    "Kunzwa zita raJesu.<br><br>" +                    "Kana tichikwira uko,<br>" +                    "Tisvike kuna Jesu;<br>" +
                    "Tichakurumbidza zita,<br>" +                    "Zita raShe Jesu.";
    String hymn16 =
            "Tine chipo chakakomba<br>" +                    "Chatakapiwa iyesu;<br>" +                    "Tachipiwa naJehovha,<br>" +                    "Icho chipo chatinacho.<br><br>" +
                    "Chakomba ichi chipo,<br>" +                    "Kwavari vakachiwana;<br>" +                    "Vanochida kwazvo icho,<br>" +                    "Pamusoro pezvinhu zvose.<br><br>" +
                    "Chine simba icho chipo,<br>" +                    "Kwavari vakachiwana;<br>" +                    "Choupenyu icho chipo,<br>" +                    "Kwavari vakachigam’chira.<br><br>" +
                    "Icho chipo ndiye Jesu,<br>" +                    "Chatakapiwa iyesu;<br>" +                    "Uri chipo chakakomba,<br>" +                    "Kwavari vanomutenda.<br><br>" +
                    "Tinomutenda Jehovha,<br>" +                    "Naicho chipo chikuru;<br>" +                    "Tinom’tenda Mwari oga,<br>" +                    "Nokutipa mwana wake.";
    String hymn17 =
            "KRISTU Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Wakatakura kuipa kwedu,<br>" +                    "Wapedza basa rake.<br>" +
                    "Wakakunda kufa, wakakunda kufa.<br>" +                    "Areruya! Areruya! Areruya! Amen.<br><br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +
                    "Ngavafare vanhu vose.<br>" +                    "Ngavaimbe pamwe chete.<br>" +                    "Wamuka nhasi, Wamuka nhasi.<br>" +                    "Areruya! Areruya! Areruya! Amen.<br><br>" +
                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Wakapedza basa guru,<br>" +                    "Tose takawana tsitsi,<br>" +
                    "Hosana kwaAri! Hosasa kwaAri!<br>" +                    "Areruya! Areruya! Areruya! Amen.<br><br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +                    "Kristu Wamuka nhasi! Wamuka kwazvo!<br>" +
                    "Ngavaimbe vanhu vose,<br>" +                    "Ngavaimbe norufaro,<br>" +                    "Nziyo dzakanaka, nziyo dzakanaka.<br>" +                    "Areruya! Areruya! Areruya! Amen.";
    String hymn18 =
            "Ndinobva kwamuri," +                    "<br> ndinoenda kudenga,<br>" +                    "Ndinoenda kuimba yaBaba;<br>" +                    "Kune iyi imba inoutsvene ‘ukuru,<br>" +
                    "Ndinokugadzirirai nzvimbo.<br><br>" +                    "Kana ndichienda," +                    "ndokudzokerai,<br>" +                    "A ‘vanhu venyika havaone:<br>" +
                    "Kana ndichidzoka ndokugam’chirai,<br>" +                    "Tigare panzvimbo ndinemi.<br><br>" +                    "Iri ‘zwi raMambo," +                    " riri ‘zwi ro’faro,<br>" +
                    "Farai! Vatendi, farai!<br>" +                    "Ishe wakaenda, asi achadzoka,<br>" +                    "Apinze kudenga imi mose.<br><br>" +                    "Ipapo togara," +
                    "pautsvene kwazvo,<br>" +                    "Navazhinjizhinji chokwadi;<br>" +                    "Neredu ir’zwi tiri pana vamwe,<br>" +                    "Tokudza Ishe wokudenga.";
    String hymn19=
            "MWEYA Mutsvene waMwari!<br>" +                    "Gara muno mumba;<br>" +                    "Buruka zvino nesimba,<br>" +                    "Uya, Mweya, uya!<br><br>" +
                    "Uya Mweya kufanana<br>" +                    "Kupenya kwezuva;<br>" +                    "Vhenekera moyo yedu,<br>" +                    "Onisa kuipa.<br><br>" +
                    "Onisa rushavashava,<br>" +                    "Nezvirwere zvose,<br>" +                    "Titungamire panzira,<br>" +                    "Panoenda vatsvene.<br><br>" +
                    "Uya serimi romoto,<br>" +                    "Pisa moyo yedu,<br>" +                    "Tichive zviteuriro<br>" +                    "Kuna Ishe wedu.<br><br>" +
                    "Uya Mweya kufanana<br>" +                    "Dova rokudenga,<br>" +                    "Mwoyo isingabereke<br>" +                    "Ive namapudzi.<br><br>" +
                    "Uya senjiva yedenga,<br>" +                    "Utivumbamire<br>" +                    "Nemapapiro orudo,<br>" +                    "Noruregerero.<br><br>" +
                    "Uya sedutu remhepo,<br>" +                    "Netsitsi nengoni,<br>" +                    "Kuti vanhu vakuone,<br>" +                    "Nokupenya kwako.<br><br>" +
                    "Mweya Mutsvene waMwari!<br>" +                    "Tarasika isu;<br>" +                    "Buruka zvino nesimba,<br>" +                    "Uya, Mweya, uya!";
    String hymn20 =
            "Simudzai kufunga kwedu<br>" +                    "Mweya woutsvene;<br>" +                    "Tifunge mabasa ako,<br>" +                    "Tidzidzese nawo,<br><br>" +
                    "Iro zuva rokuuya,<br>" +                    "Ngarisvike zvino;<br>" +                    "Kuti iwo moto wako<br>" +                    "Usvike kwatiri.<br><br>" +
                    "Tambanudza ndimi dzedu,<br>" +                    "Dzidzidziswe newe;<br>" +                    "Tizviteurire.<br><br>" +                    "Kusangana kwamashoko,<br>" +
                    "Takakumirira;<br>" +                    "Uya mweya woutsvene,<br>" +                    "Ita basa pano.<br><br>" +                    "Uya nesimba zvikuru,<br>" +
                    "Zadza iyi nzvimbo;<br>" +                    "Tigonzwa masimba ako<br>" +                    "Nokuita kwako.<br><br>" +                    "Chikurumidza kuuya,<br>" +
                    "Mweya woutsvene;<br>" +                    "Chinzwa miteuro yedu,<br>" +                    "Utiburukire.";

    String hymn21=
            "Tine dama rako Mwari,<br>" +                    " Noupenyu naro, <br>" +                    "Tinoziva zvakaipa,<br> " +                    "Muponisi wedu<br><br>" +
                    "Rakafamba iro dama,<br>" +                    " Richafamba iro,<br> " +                    "Ose marudzi avanhu,<br>" +                    " Amirira iro<br><br>" +
                    "Dzinokundwa hondo dzose<br>" +                    " Neri dama Ishe,<br> " +                    "Ichazara nyika yese,<br>" +                    "Neri dama Ishe<br><br>" +
                    "Dzose nzizi dzapanyika,<br>" +                    " Dzichafara naro,<br>" +                    " Navanhu vose venyika,<br>" +                    " Vopfumiswa naro<br><br>" +
                    "Dzichapera hondo dzose,<br>" +                    " Nezwi rako Mwari, <br>" +                    "Kuchauya Kuwadzana,<br>" +                    " Nezwi rako Mwari<br>";
    String hymn22=
            "Dzidzisai vadzidzisi,<br> " +                    "Imi vanhu vake! <br>" +                    "Mudzidziswe izwi rake,<br>" +                    " Kudzo dzose nyika<br><br>" +
                    "Asi ngoro yezwi rako,<br>" +                    " Ngaifambe iyo, <br>" +                    "Kudzo dzose nzvimbo, Jesu,<br>" +                    " Ngaifambe iyo<br><br>" +
                    "Vadzidzisi dzidzisai,<br>" +                    " Imi vanhu vake!, <br>" +                    "Ngarinzwiwi dama rake,<br>" +                    " Navo vanhu vose<br><br>" +
                    "Asi dama rako, Ishe,<br>" +                    " Ngarisvike muno,<br>" +                    " Ngarikwane nyika yose,<br>" +                    " Kudzo dzose nzvimbo<br><br>" +
                    "Asi nyika dziri kure,<br>" +                    " Ngadzizive idzo, <br>" +                    "Dzitarire kuna Jesu,<br>" +                    " Dzichitenda Iye<br><br>";

    String hymn23=
            "Riripo tsime rizere,<br>" +                    " Neropa raJesu,<br> " +                    "Vatadzi vakashamba ‘mo,<br>" +                    " Vakachena kwazvo<br><br>" +
                    "Korus <br>" +                    "Ndinotenda, ndinofara,<br>" +                    " Jesu wandifira,<br>" +                    " Napamuchinjikwa ropa,<br>" +
                    " Randaparadzirwa<br><br>" +                    "Uyo m’pati wakafara,<br>" +                    " Kuona tsime ‘ro,<br>" +                    " Neni mutadzi mukuru,<br>" +
                    " Ndinotenda kwazvo<br><br>" +                    "Iwe, Gwayana raMwari,<br>" +                    " Ropa rine masimba,<br>" +                   " Kutisunungura isu,<br>" +
                    " Pane zvakaipa<br><br>" +                    "Handifanire kupinda,<br>" +                    " Kudenga kutsvene,<br>" +                    " Asi Iwe wakaripa,<br>" +
                    " Mhosva dzangu dzose<br><br>" +                    "Ndichaimba nero shoko,<br>" +                    " Nguva dzangu dzose,<br> " +                    "Nokudenga ndichifara,<br>" +
                    " Nokusingaperi<br>";
    String hymn24=
            "Paimba yeGwayana raMwari,<br>" +                    " Ichiripo nzvimbo yokupinda,<br>" +                    "Pindai, pindai, nzvimbo ichiripo<br><br>" +                    "Ruripo rufaro nokuimba, <br>" +
                    "Ruripo rudo rwose nengoni,<br>" +                    " Pindai ,pindai nzvimbo ichiripo<br><br>" +                    "Tinodaidzwa naiye Muridzi,<br>" +                    " Anoda kuti vose vapinde,<br>" +
                    " Pindai ,pindai nzvimbo ichiripo<br><br>" +                    "Wapera musi, ravira zuva,<br>" +                    " Kwaiva nemimvuri mirefu,<br> " +                    "Pindai ,pindai nzvimbo ichiripo<br><br>" +
                    "Imba yesvitsa yoda kuzara, <br>" +                    "Uchakazarurirwa Mukuwasha,<br> " +                    "Pindai ,pindai nzvimbo ichiripo<br><br>" +                    "Chenjera kuzaririrwa gonhi,<br>" +
                    "Kana zvichinzi,”Nzvimbo haipo”,<br>" +                    " “Haipo, haipo,nzvimbo haipo”<br>";
    String hymn25=
            "Ishe ndinzwe nokufara, <br>" +                    "Ndinzwe netsitsi dzako,<br>" +                    " Dzaunopa vanhu vose,<br>" +                    " Ngadziuye pandiri, pandiri<br><br>" +
                    "Rega kundisiya, Baba,<br>" +                    " Kana ndiri mutadzi,<br>" +                    "Ndinokuipa pamoyo,<br>" +                    " Asi uya pandiri, pandiri<br><br>" +
                    "Uya pano, Muponisi!,<br>" +                    " Ngandichengetwe newe,<br>" +                    " Kana uchindishevedza,<br> " +                    "Ndichauya kwauri,kwauri<br><br>" +
                    "Mweya Mutsvene waMwari!,<br>" +                    "Rega kundipfuura,<br>" +                    "Ngandione ndiri bofu,<br>" +                    "Taura izwi resimba, resimba<br><br>" +
                    "Rudo rwako Mwari, Baba,<br>" +                    " Ropa raIshe wangu,<br>" +                    " Nokuwadzana KwoMweya,<br> " +                    "Kungavepo kwandiri, kwandiri<br>";
    String hymn26=
            "Ndinochema. Ishe Mwari!,<br>" +                    " Baba muri Mutsvene, ndinzwe,<br>" +                    " Handina kufara Mambo,<br>" +                    " Ndiponise Ishe wangu<br><br>" +
                    "Ndiri hwai, ndarasika,<br>" +                    " Nganditsvakwe, ndidzoswezve,<br>" +                    " Ndiri pasi pamapako,<br> " +                    "Chindironda Ishe wangu<br><br>" +
                    "Ndakarasa nzira yako,<br>" +                    " Ndikarega tsitsi dzako,<br>" +                    " Ndikakwira pamukwidza, <br>" +                    "Ndikanyura pakaipa<br><br>" +
                    "Pane rima rakakomba,<br> " +                    "Buda, Zuva rakanaka!, <br>" +                    "Ngandipinde pane nzira <br>" +                    " Ndiponiswe,Ishe,Jesu<br><br>";
    String hymn27=
            "Jesu ndanga ndakurasa,<br>" +                    " Asi wanga wandifira,<br>" +                    "Asi nhasi ndinonyara <br>" +                    ",Pamhinzha undigam’chire<br><br>" +
                    "Handina kufanira ini,<br>" +                    " Kuitirwa idzo tsitsi,<br>" +                    "Zvino ndinoita Seiko?,<br>" +                    " Pamhinzha undigam’chire<br><br>" +
                    "Ndino kuipa kukuru, <br>" +                    "Nhasi kwandimanikidza,<br> " +                    "Ndakatarisa kudenga,<br>" +                    " Pamhinzha undigam’chire<br><br>" +
                    "Zvose zvandanga ndaita,<br>" +                    " Zvaipa ndinozvinyara,<br>" +                    " Ishe wangu nechokwadi,<br>" +                    " Pamhinzha undigam’chire<br><br>" +
                    "Ishe, Jesu, ndinochema,<br>" +                    " Zvino ndiri pasi pako,<br> " +                    "Ndochemera mhosva yangu,<br> " +                    "Pamhinzha undigam’chire<br><br>";
    String hymn28=
            "Uya mwoyo wangu,<br> " +                    "Uya kuna’she wangu,<br>" +                    " Uya nhasi wakaipa,<br>" +                    " Usaende pano rufu,<br> " +
                    "Uya mwoyo wangu<br><br>" +                    "Chema mwoyo wangu,<br>" +                    " Nezvakaipa zvangu,<br>" +                    " Zvakaipa zvinonyadza,<br>" +
                    " Asi ini ndichinazvo,<br>" +                   " Chema mwoyo wangu<br><br>" +                    "Teura mwoyo wangu,<br>" +                    " Uya kuMununuri,<br>" +
                    " Daidza iwe kuna’she,<br> " +                    "Unonzwa iye kudenga,<br>" +                    " Teura mwoyo wangu<br><br>" +                    "Imba mwoyo wangu,<br> " +
                    "Tenda kuna ‘She wangu,<br> " +                    "Wakambouya panyika,<br>" +                    " Kuti ndiende kedenga,<br>" +                    " Imba mwoyo wangu<br><br>" +
                    "Fara mwoyo wangu,<br> " +                    "kuMununuri wangu,<br> " +                    "Wakauya kundifira,<br> " +                    "Zvino wakandiponesa,<br>" +
                    " Fara mwoyo wangu<br>";
    String hymn29=
            "Baba ndiri mwana wako<br>" +                    "Kana ndakatadza;<br>" +                    "Ndinochema mberi kwako,<br>" +                    "Baba ndiregerere<br><br>" +
                    "Zvitadzo zvangu zvizhinji<br>" +                    "Hazvingaverengwi;<br>" +                    "Ndinozviisa kwauri<br>" +                    "Baba ndiregerere.<br><br>" +
                    "Mirau yeko ndakatyora,<br>" +                    "Iwe ndakuzvidza,<br>" +                    "Mununuri ndamurasa<br>" +                    "Baba ndiregerere.<br><br>" +
                    "Ndakatadza nokureva<br>" +                    "Ndakatdza kufunga <br>" +                    "Ndakatadza namabasa,<br>" +                    "Baba ndiregerere.<br><br>" +
                    "Kana ndanga ndafanira<br>" +                    "Nokukurumbidza;<br>" +                    "Ndatadza nokukanganwa;<br>" +                    "Baba ndiregerere.<br><br>" +
                    "Nezvakaipa zvizhinji<br>" +                    "baba, ndakatadza,<br>" +                    "Ndakakunyadzisai iwe,<br>" +                    "Baba ndiregerere.<br><br>" +
                    "Uri Mwari mune ngoni<br>" +                    "Dzisina kupera.<br>" +                    "Naizvozvo ndinochema;<br>" +                    "Baba ndiregerere.<br>";
    String hymn30=
            "Rakanaka iro zuva<br>" +                    "Randakatenda kuna’she!<br>" +                    "Mwoyo wangu fara zvako,<br>" +                    "Udza vanhu vose iro.<br><br>" +
                    "Korus<br>" +                    "Ranaka, ranaka, raJesu wakandishamba.<br>" +                    "Iye wakandidzidzisa kurinda nokuteura,<br>" +                    "Ranaka, ranaka, raJesu wakandishamba.<br><br>" +
                    "Chanaka chitenderano<br>" +                    "Chinondisunga kuna’she!<br>" +                    "Ngaizadzwe imba yako<br>" +                    "Norwiyo rwandinoimba.<br><br>" +
                    "Rakapera basa guru;<br>" +                    "Ndiriwake, uri wangu:<br>" +                    "Wakandizvuva norudo<br>" +                    "Ndikamutevera ini.<br><br>" +
                    "Mwoyo wangu! chizorora!<br>" +                    "Wakatsaukaniswa kare:<br>" +                    "Rega kubva kuna Ishe,<br>" +                    "Kwa’ri zvose zvakanaka.<br><br>" +
                    "Nokudenga kwakachinzwa<br>" +                    "I’chitenderano changu;<br>" +                    "Napakufa ndingatende<br>" +                    "Nokuti ini ndiri wake.<br>";
    String hymn31=
            "Una vanhu vako, Mwari<br>" +                    "Kudzo dzose nguva;<br>" +                    "Unovachengeta iwe,<br>" +                    "Pane nzvimbo dzose.<br><br>" +
                    "Kana voyambuka nzizi,<br>" +                    "Uve navo iwe;<br>" +                    "Kana vapiswa nomoto,<br>" +                    "Vanochengetwa newe.<br><br>" +
                    "Pavanokutambudzika<br>" +                    "Vanosimba newe;<br>" +                    "Nepane zvinovaruma,<br>" +                    "Unovachengeta.<br><br>" +
                    "Ishe vatarire iwe,<br>" +                    "Ivo vanhu vako;<br>" +                    "Vanotenda, vanofunga,<br>" +                    "Ivo vanhu vako.<br>";
    String  hymn32 =
            "MWEYA wangu uno Muponisi,<br>" +                    "Ndakasunungurwa;<br>" +                    "Musununguri ngandinaniswe,<br>" +                    "Ndichagam’chirwasu?<br><br>" +
                    "Korus<br>" +                    "Ndoda, ndoda, ndoda<br>" +                    "Mwari muyamuri uri wangu:<br>" +                    "Ndakatengwa neropa raIshe,<br>" +
                    "Ndava wake chose.<br>" +                    "<br><br>Nengoni ndichagam’chira tsitsi,<br>" +                    "Rudo rwako Kristu<br>" +                    "Rwaukunda moyo wangu kwazvo,<br>" +
                    "Ndichavimba newe.<br><br>" +                    "Unoziva kusasimba kwangu,<br>" +                    "Ndotya kurasika,<br> "+                    "Asi iwe uri simba rangu<br>" +
                    "Unondipa simba<br><br>" +                    "Hongu, Ishe, tipe isu tose,<br>" +                    "Ngoni dzako nhasi,<br>" +                    "Nezvinobva pamwoyo tichiti:<br>" +
                    "“Ndichava waKristu”.<br><br>" +                    "Vakauya vamwe vachibunza:<br>" +                    "“Tingapone here?”<br>" +                    "“Hongu, ndinoda muponisiwe”<br>" +
                    "Nesu tinodaro.<br>";
    String hymn33=
            "Tiri vawadzani, vawadzani,<br>" +                    "Mhuri yaJesu Mambo wedu:.<br>" +                    "Dai tichidana, dai tichidana,<br>" +                    "Hapana usvinu kudenga.<br><br>" +
                    "Tinoyamurana,tinoyamurana,<br>" +                    "Vatendi vaIshe mukuru,<br>" +                    "Tisingatsaukane,tisingatsaukane ,<br>" +                    "Hakuna kudaro kudenga,<br><br>" +
                    "Tiri hondo imwe, tiri hondo imwe,<br>" +                    "Mbiri dzaMambo mukuru:<br>" +                    "Ngatimurwirei nomwoyo mumwewo,<br>" +                    "Panzira inoenda kudenga.<br><br>" +
                    "Iko kudenga kuno rufaro bedzi;<br>" +                    "Titende kuna Ishe mukuru;<br>" +                    "Naiwo masimba anobva kuna’She<br>" +                    "Tinosvika nawo kwaari.<br>";
    String hymn34=
            "Fambai vatendi, fambai kurwa<br>" +                    "Munotungamirirw a noMuchinjikwa,<br>" +                    "Kristu Ishe wedu, Mutungamiri,<br>" +                    "Fambai sehondo nesimbarake,<br>" +
                    "Fambai vatendi, fambai kurwa,<br>" +                    "Munotungamirirwa noMuchinjikwa.<br><br>" +                    "Satani achatiza, anotya kwazvo,<br>" +                    "Fambai vatendi, mugom’kunda<br>" +
                    "Anozunguzika namanzwi enyu,<br>" +                    "Simudzirai manzwi, imbaimose.<br><br>" +                    "Inoenda sehondo Kokorodzano,<br>" +                    "Ichifamba shure Vatsvene vose,<br>" +
                    "Tisats’ukaniswe , muviri mumwe,<br>" +                    "Mumwe norutendo, mumwe norudo.<br><br>" +                    "Hunogoparadzwa umambo hwose,<br>" +                    "Govero raJesu rinogosara,<br>" +
                    "Hondo yaSatani isingagone<br>" +                    "Ma’ama aJesu achazadziswa.<br><br>" +                    "Ndizvo fambai, fambai nesu,<br>" +                    "Rwiyo rwokukunda ngatiimbei;<br>" +
                    "Ngatikurumbidze Kristu Ishe,<br>" +                    "Namazuva ose asingaperi.<br>";
    String hymn35=
            "Ndanzwa inzwi rako,<br>" +                    " Rinondidaidza, <br>" +                    "Ndishambidze mwoyo wangu <br>" +                    "Pane ropa rako.<br><br>" +
                    "Korus<br>" +                    "Ndouya, Jesu!<br> " +                    "Kwauri Ishe! <br>" +                    "Shambidza mwoyo wangu<br> " +                    "Pane ropa rako. <br><br>" +                    "Ndashaya masimba,<br> " +
                    "Iwe uchandipa;<br>" +                    " Uchandishambidza kwazvo<br>" +                    " Uchanditsvenisa.<br><br>" +                    "Jesu wandidana <br>" +
                    "Nditsvake rutendo<br>" +                    " Norudo noruregerero,<br>" +                    " Pasi nokudenga. <br><br>" +                    "Jesu wasimbisa<br>" +
                    " Basa rakanaka;<br>" +                    " Wapamhidza ngoni dzake<br> " +                    "Pano mwoyo wangu.<br><br>" +                    "Jesu wakandipa <br>" +
                    "Tsitsi dzake dzose;<br>" +                    " Wandipa ruregerero<br>" +                    " Norutendo rwake.<br>";
    String hymn36=
            "Vazhinji vanayo nhaka<br>" +                    " Yavanozviinzva nayo<br> " +                    "Vazhinji vanayo pfuma <br>" +                    "Yavanozvifarisa nayo<br><br>" +
                    "Handizvidze zvipo zvako<br> " +                    "Zvohuhu upenyu huripo<br> " +                    "Asi iwi Ishe Jesu<br> " +                    "Uri nhaka yangu kwazvo<br><br>" +
                    "Kunyange ndanga ndisina<br>" +                    " Zvinhu zvoruno rugaro<br>" +                    " Ndinewe muridzi wazvo<br>" +                    " Ndine zvinhu zvose newe<br><br>" +
                    "Kana mava wangu Jesu<br>" +                    " Ndakwana nezvinhu zvose<br>" +                    " Nezvi zviripo ndezvangu<br>" +                    " Nezvinouya ndezvangu<br><br>" +
                    "Neino nyika ndeyangu <br>" +                    "Nairo denga nderangu <br>" +                    "Nahwo upenyu ndohwangu<br>" +                    " Nokunakirwa ndokwangu<br><br>" +
                    "Hahuperi uhwo upenyu<br>" +                    " Huri nhaka yangu newe <br>" +                    "Kunakirwa hakuperi<br>" +                    " Kwandakawana kunewe<br>";
    String hymn37=
            "Ngandibereke mapudzi<br>" +                    "Ayo oMweya Mutsvene<br>" +                    "Ohunhu nokururama,<br>" +                    "Nduramo nomwoyo chena,<br>" +
                    "Izvo zvose zvorutendo<br>" +                    "Nezvorudo norufaro.<br><br>" +                    "Izvo zvinhu ngazvikure<br>" +                    "Mumwoyo nenguva dzose,<br>" +
                    "Zvindiyamure ndidzure<br>" +                    "Kose uku kumanikwa<br>" +                    "Kousvinu nokwetsino;<br>" +                    "Nokwezvinhu zvinobvako.<br><br>" +
                    "Hongu, Ishe nganditunge,<br>" +                    "Ndivewo unobereka,<br>" +                    "Ndivavarire kuwana<br>" +                    "Zvosewo zvakarurama,<br>" +
                    "Zvigorega kuzorambwa<br>" +                    "Hwose unhu nadzo tsika.<br>";
    String hymn38=
            "Mufudzi ndiye Jehovha<br>" +                    "Wakandichengeta:<br>" +                    "Kushaya hakungavepo,<br>" +                    "Unovimba naye.<br><br>" +
                    "Pana mafuro manyoro<br>" +                    "Ndinodyiswa napo,<br>" +                    "Ndinorara nokufara,<br>" +                    "Ndisingavundutswe.<br><br>" +
                    "Unounatsa nomweya,<br>" +                    "Unouponisa.<br>" +                    "Kururama ndova nako<br>" +                    "Naiye Mufudzi.<br><br>" +
                    "Kana ndifambe parima<br>" +                    "Handingatye chinhu;<br>" +                    "Nokuti iwe uneni<br>" +                    "Unondifarisa.<br><br>" +
                    "Chidyiro ini ndinacho<br>" +                    "Mberi pavavengi,<br>" +                    "Mafuta pamusoro wangu<br>" +                    "Handishayi chinhu.<br><br>" +
                    "Kururama nedzo tsitsi,<br>" +                    "Dzinonditevera;<br>" +                    "Pane imba yaJehovha,<br>" +                    "Nokusingaperi.<br>";
    String hymn39=
            "Nditarire nokufara,<br>" +                    "Ishe wangu!<br>" +                    "Ndiwe wanga wandifira,<br>" +                    "Ishe wangu!<br>" +
                    "<br>Waburuka denga rako,<br>" +                    "Uchisiya upenyu hwako,<br>" +                    "Ndanzwa ruponiso rwako,<br>" +                    "Ishe wangu!<br><br>" +
                    "Ndangandigere pane rima,<br>" +                    "Ishe wangu!<br>" +                    "Ndandiende pane rufu,<br>" +                    "Ishe wangu!<br>" +
                    "<br>Dzakauya nhume dzako.<br>" +                    "Dzandinzwisa dama rako,<br>" +                    "Dzandiudza tsitsi dzako,<br>" +                    "Ishe wangu!<br><br>" +
                    "Ngandidzinzwe ngoni dzako,<br>" +                    "Ishe wangu!<br>" +                   "Ndive muponiswa wako,<br>" +                    "Ishe wangu!<br>" +
                    "<br>Zvakaipa ngazvipere,<br>" +                    "Mwoyo uve noutsvene,<br>" +                    "Ndinzwe undireverere,<br>" +                    "Ishe wangu!";
    String hymn40=
            "Nditungamire, Jehovha<br>" +                    "Ndiri mufambi Ishe;<br>" +                    "Unesimba ini handina,<br>" +                    "Ndashaya simba ini<br>" +
                    "O M’ponisi<br>" +                    "Ndiwe nhowo yangu.<br><br>" +                    "Iro tsime roruponiso<br>" +                    "Razarurirwa ini;<br>" +
                    "Ngarierere ndipone,<br>" +                    "Rishambe zvakaipa<br>" +                    "O M’ponisi<br>" +                    "Iwe ndosimba newe.<br><br>" +
                    "Kuti ndasvika Jordhani,<br>" +                    "Chibvisa kutya kwangu;<br>" +                    "Ndiperekedze ndouya<br>" +                    "Chindichengeta ini,<br>" +
                    "O M’ponisi<br>" +                    "Iwe ndovimba newe <br>";
    String hymn41=
            "Ishe Taungana<br>" +                    "Muno mumba yako,<br>" +                    "Uya newe, zvatapinda<br>" +                    "Ishe mberi kwako.<br><br>" +
                    "Iyo mwoyo yedu<br>" +                    "Inokurwarira;<br>" +                    "Nayo mweya yedu Ishe<br>" +                    "Inokutarira.<br><br>" +
                    "Hurukuro dzako,<br>" +                    "Baba, ngatidzinzwe;<br>" +                    "Razarurwa dama renyu<br>" +                    "Newe ngatikunzwe.<br><br>" +
                    "Ngautigadzire,<br>" +                    "Isu vanhu vako<br>" +                    "Kana tafa, tipinzewo<br>" +                    "Kune denga rako.<br>";
    String hymn42=
            "Zvatapinda Ishe wedu<br>" +                    "Kure imba yako,<br>" +                    "Titarire Mwari wedu<br>" +                    "Nedzo tsitsi dzako.<br><br>" +
                    "Imba iya imba yako,<br>" +                    "Imba youtsvene;<br>" +                    "Ishe uya tisangane,<br>" +                    "Utiropafadze.<br><br>" +
                    "Tinobvuma zvakaipa,<br>" +                    "Mberi kwako Ishe;<br>" +                    "Tinokukumbira isu,<br>" +                    "<br>Zvakaipa zvatinazvo,<br>" +
                    "Iwe unoziva;<br>" +                    "Tinochema naizvozvo,<br>" +                    "Nayo mweya yose.<br><br>" +                    "Tifadzise Ishe wedu,<br>" +
                    "Noruregerero rwako;<br>" +                    "Tipupure Mwari wedu,<br>" +                    "Noyu mweya wako.<br><br>" +                    "Rotaurwa dama rako,<br>" +
                    "Ngatirinzwe tose;<br>" +                    "Tichiva nomwenje,<br>" +                    "Pane nguva dzose.";
    String hymn43=
            "Famba mangwanangwana,<br>" +                    "Famba masikati,<br>" +                    "Famba zuva radoka,<br>" +                    "Famba pausiku;<br>" +
                    "Famba nomwoyo mutswene,<br>" +                    "Urege kutyiswa,<br>" +                    "Upfugame namabvi,<br>" +                    "Teura kwaari.<br><br>" +
                    "Kumbirira shamwari,<br>" +                    "Vose unovada;<br>" +                    "Kumbirira vavengi,<br>" +                    "Rega kuvasiya,<br>" +
                    "Shure kwazvo kumbira<br>" +                    "Chootsvaga oga,<br>" +                    "Nero Zita raJesu<br>" +                    "Mununuri wako.<br><br>" +
                    "Kana washaya nzvimbo,<br>" +                    "Yokugara woga,<br>" +                    "Kana varipo vamwe,<br>" +                    "Zvimwe une basa;<br>" +
                    "Chimutsa moyo wako,<br>" +                    "Mwari anokunzwa,<br>" +                    "Kufunga kwedu kose<br>" +                    "Kunozibwa naye.<br><br>" +
                    "Kana waona nhamu,<br>" +                    "Teura kwaari,<br>" +                    "Neparufaro rwako,<br>" +                    "Tenda kuna Mwari;<br>" +
                    "Simba raakatipa,<br>" +                    "Rinokuna zvose,<br>" +                    "Simba rokuteura<br>" +                    "Kuna Mwari wedu.";
    String hymn44=
            "Wakatora chipapata,<br>" +                    "Ukachimedura<br>" +                    "Ukati torai mudye.<br>" +                   "Zvomuviri wangu.<br>" +
                    "<br>" +                   "Jesu watora mukombe.<br>" +                    "Wati ngatimutende.<br>" +                    "Ndochitenderano chitsva.<br>" +
                    "Pane ropa rangu.<br>" +                    "<br>" +                    "Tinotora chipapata,<br>" +                    "Totarira iwe;<br>" +
                    "Tinotora tidye tose.<br>" +                    "Tichisuwa Iwe.<br>" +                    "<br>" +                    "Tinotora mukombe<br>" +
                    "Tichivimba newe,<br>" +                    "Tinonwa kwauri tose,<br>" +                    "Tichifunga Iwe";
    String hymn45=
            "Kwasara makore,<br>" +                    " Nenguva shomana, <br>" +                    "Tinoenda kuna navo, <br>" +                    "Vari kumakuva.<br>" +                    "<br>Korus<br>" +                    "Mweya wangu Ishe, <br>" +
                    "Ngaururamiswe;<br>" +                    " Ndishambidze pane ropa,<br>" +                    " Bisa zvakaipa.<br>" +                    "<br>Kwasara mazuva,<br>" +                    " Atinawo isu;<br>" +                    " Shure kwezvo tichaenda,<br>" +
                    " Kuno mutongisi.<br>" +                    "<br>Kwasara nenhamu,<br>" +                    " Dzatinogoona;<br>" +                    " Tinoenda pasine nhamu,<br>" +                    " Nyika yakanaka.<br>" +
                    "<br>Kwasara misodzi,<br>" +                    " Nezvo zvinorema;<br> " +                    "Tichaonana naBaba,<br> " +                    "Pasina kuchema.<br>" +
                    "<br>Kwasara masvondo,<br>" +                    " Mazuva matsvene;<br>" +                    "Tichamunamata Mwari,<br>" +                    " Kune denga rake.<br>" +
                    "<br>Kwasara chinguva,<br>" +                    " Achauya Jesu, <br>" +                    "Wakambotifira kuti<br>" +                    " Tive neumambo<br>";
    String hymn46=
            "Wauya Wauya Mucheki mukuru;<br>" +                    "Vanhu vachaona Ishe wokudenga.<br>" +                    "Vanogozomutswa vari kumakuva;<br>" +                    "Avo vaonekwe vose pakachena.<br><br>" +                    "Zvinhu zvatinoona zvose zvichatsva,<br>" +                    "Makomo mapako zvichanyongodeka.<br>" +
                    "Zuva richadzimwa, mwedzi uchapera,<br>" +                    "Vakaipa vachashaiwa pokuvanda.<br><br>" +                    "Mucheki wosvika nehondo huru<br>" +                    "Hondo inouya yavanyai vedenga<br>" +
                    "Nameso omucheki mukuru aone,<br>" +                    "Zvinhu zvakavanda, zvinhu zvakaipa.<br><br>" +                    "Vatadzi vanova nokutya kukuru,<br>" +                    "Vanogodedera pameso’mucheki.<br>" +                    "Vasakarurama vachazoparadzwa,<br>" +                    "Vaiswe munzvimbo yokutambudzika.<br><br>" +                    "Regai zvakaipa, mutye mururame,<br>" +                    "Munzwe inzwi raShe, munamate mose.<br>" +                    "Zviteurirei, mutsvake netsitsi,<br>" +                    "Inguva nazvino," +                    "Uyai mugamuchire.<br>";
    String hymn47=
            "Mumhanzi uri kudenga<br>" +                    "Kana kozoridzwa iwo<br>" +                    "Nokuriridza kukuru<br>" +                    "Kana kozonzwika iko<br>" +                    "Kuparure namakuva<br>" +                    "Kutsemure napanyika.<br><br>" +
                    "Negungwa rinovabisa<br>" +                    "Ivavo varakamedza<br>" +                    "Nenyika inovabisa<br>" +                    "Vose vakanga vavigwa<br>" +                    "Vamukire pano rufu<br>" +                    "Vanoenda pakutongwa<br><br>" +
                    "Vati ivo vakafira <br>" +                    "Pane zvakaipa zvavo<br>" +                    "Nenguva yavanoona<br>" +                    "Ichocho chityiso chavo<br>" +
                    "Vawe vose pane gomba<br>" +                    "Vakandirwe pano moto<br><br>" +                    "Ndivo vakanaka voga<br>" +                    "Vanopona noyo musi<br>" +
                    "Ndavakatongerwa voga<br>" +                    "Vanozopinda kudenga<br>" +                    "Vaine mibayiro yavo<br>" +
                    "Vaina M'ponisi wavo<br>";
    String hymn48=
            "Chinhu chinotyisa kwazvo<br>" +                    " Zuva rokupera;<br>" +                    " Kana Ishe achitonga <br>" +                    "Kokupedzisira.<br><br>" +
                    "Kuriko nokuvandana<br>" +                    " Pane ino nyika;<br> " +                    "Naikoko kuvandana<br>" +                    " Kwouya pachena.<br><br>" +
                    "Pane nyika kunotadzwa<br>" +                    " Kusina kunzwika;<br>" +                    "Nyamba kwose kwakanzwika<br>" +                    " Nomuzivi zvose.<br><br>" +
                    "Nero zuva pamibvunzo<br>" +                    " Kunonzwika zvose;<br>" +                    " Zvakaitwa panyika<br>" +                    " Kumarudzi ose.<br><br>" +
                    "Ngavadzoke vakaipa<br> " +                    "Pakuipa kwavo;<br>" +                    " Teurai nhasi mose<br>" +                    " KuMusununguri<br>";
    String hymn49=
            "Pamusoro pakudenga<br>" +                    "Ndavakanaka voga<br>" +                    "Pamsoro pakudenga<br>" +                    "Kuna vatsvene voga<br>" +
                    "<br>" +                    "Anoda kuendako<br>" +                    "Ngaazviteurire<br>" +                    "Anozogadzirirwa<br>" +
                    "Nomweya weutsvene<br>" +                    "<br>" +                    "Jesu wakatifira<br>" +                    "Kuripa mhosva dzedu<br>" +
                    "Kuti tiitwe vatsvene<br>" +                    "Naiyo mweya yedu<br>" +                    "<br>" +                    "Kuti kana tavingwa<br>" +                    "Nerufu pano pasi<br>" +
                    "Tirege kuzorambwa<br>" +                    "Kuenda pakudenga<br>";
    String hymn50=
            "Pakudenga kuna Baba<br>" +                    "Kwakanaka kwazvo;<br>" +                    "Pakudenga kuna Baba,<br>" +                    "Kwakafara kwazvo.<br><br>" +                   "Hakupindi chakaipa,<br>" +                    "Kana chiri chimwe,<br>" +
                    "Hakupindi zvokurwara,<br>" +                    "Nechirwere chimwe<br><br>" +                    "Ndavatsvene ivo voga,<br>" +                    "Vanogara ikoko;<br>" +
                    "Vanokuda vanamate,<br>" +                    "Iwe Mwari wavo,<br><br>" +                    "Vakawana musha wavo,<br>" +                    "Musha vakagara;<br>" +
                    "Vakawana noupenyu,<br>" +                    "Husingapfuure.<br><br>" +                    "Ndiri mweni pane nyika<br>" +                    "Ndinosuwa denga;<br>" +
                    "Ndandipinde newe Jesu,<br>" +                    "Ndiende kudenga.<br>" ;

    String hymn51=
            "Dombondipa meso ndione,<br>" +                    " Pauzuru kudenga;<br> " +                    "Ndivaone vano utsvene,<br> " +                    "Vanofara kunaShe.<br><br>" +
                    "Zviya zvavaiva panyika<br>" +                    " Vaichema misodzi;<br>" +                    " Vaimanikwa nokuedzwa<br>" +                    " Muedzi achiedza.<br><br>" +
                    "Ndakaona negwara rake,<br>" +                    " Ndikabvunza, ”Makadii?”<br>" +                    " Ndiyeyo wanga watifira,<br>" +                    " Wanga wafira isu.<br><br>" +
                    "Vakaona negwara rake,<br>" +                    " Raenda paupenyu;<br>" +                    " Vakafamba, pagwara rake,<br>" +                    " Vazorora kudenga.<br><br>" +
                    "Ngaarumbidzwe M’tungamiri<br>" +                    " Zvaatitungamirira;<br>" +                    " Kusashaike muteveri. <br>" +                    "Panero gwara rake<br>";
    String hymn52 =
            "Jerusarema, musha wangu!<br>" +                    "Musha wakanaka!<br>" +                    "Kana ndapedza mabasa<br>" +                    "Ndinenda kwauri.<br><br>" +
                    "Ndichauona riniko,<br>" +                    "Uyo musha wangu?<br>" +                    "Une dzimba dzakanana,<br>" +                    "Nokudya kutsvene.<br><br>" +
                    "Hapasisina kuipa,<br>" +                    "Hapana nenhamu<br>" +                    "Ndinoramba ndichienda<br>" +                    "Kumusha mutsvene.<br><br>" +
                    "Ndingatye here kurwadza?<br>" +                    "Ndigatize kufa?<br>" +                    "Kwete, ndinenda Kenani,<br>" +                    "Nyika yandinoda.<br><br>" +
                    "Vaprofita, vadziidzisi,<br>" +                    "Vakafira Jusu,<br>" +                    "Varipo pamwe naKristu,<br>" +                    "Neni ndichaenda.<br><br>" +
                    "Jerusarema, musha wangu!<br>" +                    "Wandinotsvakisa<br>" +                    "Kana ndasvika kwauri<br>" +                    "Ndichafara kwazvo<br>";
    String hymn53=
            "Nzvimbo yakanaka!<br>" +                    "Musha waJehovha.<br>" +                    "Denga ramatenga,<br>" +                    "Denga routsvene,<br>" +
                    "Iyo nzvimbo yakanaka,<br>" +                    "Ndinoenda rinhi kwairi?<br>" +                    "<br>" +                    "Anoenda muenzi,<br>" +
                    "Woda kuzorora;<br>" +                    "Hama dzangu musha,<br>" +                    "Uriko kudenga,<br>" +                    "Iyo nzvimbo yakanaka,<br>" +
                    "Ndinoenda rinhi kwairi?<br>" +                    "<br>" +                    "Pano tadzikira<br>" +                    "Matende panyika,<br>" +
                    "Hausiri musha,<br>" +                    "Tinawo kudenga,<br>" +                    "Iyo nzvimbo yakanaka,<br>" +                    "Ndinoenda rinhi kwairi?<br>" +
                    "<br>" +                    "Hapana misodzi<br>" +                    "Kum’soro kudenga,<br>" +                    "Hapana nokufa,<br>" +
                    "Nezvo zvikomero.<br>" +                    "Iyo nzvimbo yakanaka,<br>" +                    "Ndinoenda rinhi kwairi?<br>" +                    "<br>" +
                    "Zviedzo zvisipo,<br>" +                    "Nezvitadzo zvose;<br>" +                    "Ndichazororako,<br>" +                    "NoM’ponisi wangu.<br>" +
                    "Iyo nzvimbo yakanaka,<br>" +                    "Ndinoenda rinhi kwairi?<br>";
    String hymn54=
            "Nguva yakanakisisa<br>" +                    "Yokukurumbidza,<br>" +                    "Kana tadzoredzaniswa<br>" +                    "Pam'soro kudenga;<br>" +
                    "Ndizvozvo tichinzwa manzwi<br>" +                    "Echisimbisiso,<br>" +                    "Chokuti kana tikafa<br>" +                    "Pane iyo nyika.<br>" +
                    "<br>" +                    "CHORUS<br>" +                    "Tinosangana kudenga<br>" +                    "Neropa raJesu<br>" +                    "Nokutenda kuna Jesu<br>" +
                    "Tichasanganiswa.<br>" +                    "<br>" +                    "Kunakisa korugare<br>" +                    "Rwakasunga mwoyo:<br>" +                    "Isu kana taungana<br>" +                    "Pazita raKristu.<br>" +
                    "Mwanakomana waBaba<br>" +                    "Wakakomborerwa,<br>" +                    "Chifungidziro chokuti<br>" +                    "Tichasanganiswa.<br>" +
                    "<br>" +                    "Hongu, nokukurumbidza;<br>" +                    "Kukunda madzudzo;<br>" +                    "Tsoka dzedu dzakaneta<br>" +                    "Dzichayambukira<br>" +
                    "Zambuko rine ndarama<br>" +                    "Pavakagarira,<br>" +                    "Avo vanotida isu,<br>" +                    "Ruripo rufaro.<br>" +
                    "<br>" +                    "Kana takatsaukaniswa<br>" +                    "Kukange kwasvika<br>" +                    "Namazuva mashomana,<br>" +                  "Makore mashoma<br>" +
                    "Tichave naye M'ponisi,<br>" +                    "Pane idzo nzvimbo<br>" +                    "Dzatinoreverwa kunzi<br>" +                    "Tichasanganiswa.";
    String hymn55=
            "AMAI navana<br>" +                    "Vauya kuna Jesu,<br>" +                    "Vadzidzi vavadzivisa<br>" +                    "Vachiti, “Ibvai!”<br>" +
                    "Asi Jesu haabvumi<br>" +                    "Wati kuna vakukutu,<br>" +                    "“Regai vaduku musavarambise”.<br><br>" +                    "Ndinovagam’chira,<br>" +
                    "Ndinogovafungata,<br>" +                    "Ndichava mufudzi wavo,<br>" +                    "Musavarambise;<br>" +                    "Ndinoda vaduku vose<br>" +
                    "Vagare upenyu neni<br>" +                    "“Regai vaduku musavarambise”.<br><br>" +                    "Jesu wakapfava,<br>" +                    "Wakavaropafadza,<br>" +
                    "Nyamba zviuru zvevana<br>" +                    "Vasati vamuziva;<br>" +                    "Havana matama ake,<br>" +                    "Havanzwe kuti wadaro,<br>" +
                    "“Regai vaduku musavarambise”.<br><br>" +                    "Tinokuteura<br>" +                    "Kuti marudzi ose<br>" +                    "Asiye vamwari vavo<br>" +
                    "Auye kwauri.<br>" +                    "Uvavhenekere, Mwari,<br>" +                    "Uve navo noupenyu,<br>" +                    "Uvadzidzise vauye kwauri.<br>";
    String hymn56=
            "Ndiropafadze Jesu, <br>" +                    "Dzidzisa mwoyo wangu; <br>" +                    "Ndoda mwoyo muchena, <br>" +                    "Mufudzi, ndichengete.<br>" +
                    "<br>" +                    "Ndiri muduku asi, <br>" +                    "Wakadaidza vose; <br>" +                    "Ndipe zvokudya zvangu, <br>" +
                    "Mufudzi ndichengete.<br>" +                    "<br>" +                    "Ndiyamure M’ponisi;<br>" +                    " Handina simba ini; <br>" +
                    "Ndinotenda kwauri;<br>" +                    " Mufudzi ndichengete.<br>" +                    "<br>" +                    "Handidi kutsaukana, <br>" +
                    "Ndoda kugara newe;<br>" +                    " Panzvimbo yakanaka; <br>" +                    "Mufudzi ndichengete.<br>";
    String hymn57=
            "JESU , unoshevedza vaduku,<br>" +                    "Ndinouya;<br>" +                    "Bata ruoko rwangu norwako,<br>" +                    "Muponisi<br>" +
                    "Nditungamire kana ndotsauka,<br>" +                    "Ndabatwa naSatani muvengi.<br><br>" +                    "Ndinofunga kuti tsoka dzako<br>" +                    "Dzakanaka;<br>" +
                    "Dzanga dzichifamba pane nzira,<br>" +                    "Nzira yangu;<br>" +                    "Iwe wanga uchiri mucheche,<br>" +                    "Wakavakudza vazvari vako.<br><br>" +
                    "Jesu ndipe mwoyo wokufunga,<br>" +                    "Muponisi;<br>" +                    "Somwoyo wako mwoyo michena<br>" +                    "Gara neni<br>" +
                    "Shure kwezo ndinogokuziva,<br>" +                    "Ndinogokura nokuchenjera.<br><br>" +                    "Ndinogokurumbidza, M’ponisi,<br>" +                    "Misi yose;<br>" +
                    "Pakutamba napabasa rangu,<br>" +                    "Ndichaimba.<br>" +                    "Ndiyamure pakuedzwa kwangu,<br>" +                    "Ndidzidzise yose mirau yako.<br>";
    String hymn58=
            "Nhasi ndinofara ini<br>" +                    "Nairo ropa rangu;<br>" +                    "Vashamwari munodini?<br>" +                    "Ngatifare neniwo.<br><br>" +
                    "CHORUS<br>" +                    "Ishe ndinokurumbidza<br>" +                    "Iwe wandidzidzisa:<br>" +                    "Ndigogona kuakunda<br>" +
                    "Ose magwaro angu.<br>" +                    "<br>" +                    "Kana ndiri muchikoro<br>" +                    "Zvakanaka kwandiri,<br>" +
                    "Kana ndapinda musvondo<br>" +                    "Ndinofara zvikuru.<br>" +                    "<br>" +                    "Kune ino nyika yedu,<br>" +
                    "Magwaro hatizivi;<br>" +                    "Vanga vagere vadzibaba<br>" +                    "Rufaro vasinarwo.<br>" +                    "<br>" +
                    "Ngandigare ndichitenda<br>" +                    "Nairo ropa rangu,<br>" +                    "Kudzamara kupera<br>" +                    "Kugara pano kwangu.<br>";
    String hymn59=
            "Chiriko chikomo kure<br>" +                    " Kunze kwoyo musha, <br>" +                    "Paakaroverwa Ishe,<br>" +                    " Paakatifira.<br><br>" +
                    "Hatizivi isu vanhu <br>" +                    "Kurwadza kwakadii, <br>" +                    "Wakarembera pamuti <br>" +                    "Nenzira yavanhu.<br><br>" +
                    "Wakafa kuti tipone,<br>" +                    " Tive vakanaka, <br>" +                    "Kuti tiende kudenga,<br>" +                    " Tiponeswe naye.<br><br>" +
                    "Pakanga pasina mumwe <br>" +                    "Wokutinunura, <br>" +                    "Ndiye wakava nesimba<br>" +                    " Kutipinza denga.<br><br>" +
                    "Jesu wakatida isu<br>" +                    " Tisati tamuda,<br>" +                    " Takafanira kutenda<br>" +                    " Nokumuda kwazvo.<br>";
    String hymn60=
            "Mumwe ariko pam’soro;<br>" +                    "Anotida!<br>" +                    "Rudo rwake rwaakakomba:<br>" +                    "Anotida!<br>" +
                    "Hama dzedu dzinotiza<br>" +                    "Dzimwe dzinotitambudza;<br>" +                    "Haana kutinyengedza:<br>" +                    "Anotida!<br>" +
                    "<br>" +                    "Kumuziva ndoupenyu:<br>" +                    "Anotida!<br>" +                    "Wakatipa zvinhu zvose:<br>" +
                    "Anotida!<br>" +                    "Tanga tiri kure naye,<br>" +                    "Wakatitenga neropa;<br>" +                    "Wakatiisa kudenga;<br>" +
                    "Anotida!<br>" +                    "<br>" +                    "Jesu ndiShamwari wedu:<br>" +                    "Anotida!<br>" +
                    "Anoda kutifadzisa:<br>" +                    "Anotida!<br>" +                    "Mwoyo yedu inomuda<br>" +                    "Yoda kushevedzwa naye<br>" +
                    "Zvorikwazvo nechokwadi<br>" +                    "Anotida!<br>" +                    "<br>" +                    "Toregererwa zvakaipa:<br>" +
                    "Anotida!<br>" +                    "Togokunda hondo dzedu:<br>" +                    "Anotida!<br>" +                    "Anotipa zvipo zvose,<br>" +
                    "Anoda kutinakira,<br>" +                    "Achatipa noutsvene:<br>" +                    "Anotida!<br>";
    String hymn61 = "MANGWANANA zvinhu zvose<br>" +            "Zvinotenda Ishe iwe;<br>" +            "Iwe uno’penyu hwose<br>" +            "Nesu takachengwa newe.<br><br>" +
            "Iri zuva rinobuda<br>" +            "Richafamba nzira yaro<br>" +            "Iri rinotirevera<br>" +            "Rinoti uri’she waro.<br><br>" +
            "No’yu musi wakauya<br>" +            "Wava nokuedza kwawo;<br>" +            "Uyu nawo unoreva,<br>" +            "Unzi uri muiti wawo.<br><br>" +
            "Namatenga akakomba<br>" +            "Amire neminamato,<br>" +            "Ayawo anodzidzisa<br>" +            "Achiti uri muchengi.<br><br>" +
            "Zvose zvinhu zvatarira<br>" +            "Iwe kose kudya kwazvo;<br>" +            "Zvenge zvinokukumbira<br>" +            "Kwauri Musiki wazvo.<br><br>" +
            "Tinogoti Baba wedu,<br>" +            "Tikutende tikukudze,<br>" +            "Iwe M’sununguri wedu,<br>" +            "Newe Mweya Mutsvene.<br>";
    String hymn62=
            "Mumwe musi ava mauro<br>" +                    "Varwere vakaungana,<br>" +                    "Panyasi paJesu Ishe,<br>" +                    "Vakaenda norufaro.<br>" +
                    "<br>" +                    "Nanhasi isu tauya,<br>" +                    "Toswedera nezvirwere;<br>" +                    "Mumhu wako hationi,<br>" +
                    "Toziva kuti urimo.<br>" +                    "<br>" +                    "Tanda dambudziko redu;<br>" +                    "Vamwe vairwara kwazvo;<br>" +
                    "Vamwe havati vakuda,<br>" +                    "Vamwe vakarasa rudo.<br>" +                    "<br>" +                    "Vamwe vakaneta pano,<br>" +
                    "Vakashaya ruyamuro;<br>" +                    "Vamwe vane hama dzavo,<br>" +                    "Dzinovatambudza kwazvo.<br>" +                    "<br>" +
                    "Vose vanoda rufaro,<br>" +                    "Vanoda noruregerero,<br>" +                    "Navatendi vanoziva,<br>" +                    "Mwoyo yavo yakaipa.<br>" +
                    "<br>" +                    "Kristu iwe uri munhu,<br>" +                    "Wanga waedzwa zvikuru,<br>" +                    "Meso ako anoona,<br>" +
                    "Zvatinotsvaka kuvanza.<br>" +                    "<br>" +                    "Simba rako richigere;<br>" +                    "Unogona kuponesa;<br>" +
                    "Tinzwire tsitsi maur'ano<br>" +                    "Tiponise Mwari tose.<br>";
    String hymn63=
            "GARA neni izuva radoka;<br>" +                    "Rima rinosvika; gara neni!<br>" +                    "Vamwe vayamuri vakatadza,<br>" +                    "Ishe muyamuri, gara neni.<br><br>" +
                    "Ndinokutsvaka nenguva dzose;<br>" +                    "Ngoni dzako dzakunda muidzi.<br>" +                    "Unoziva kunditungamirira;<br>" +                    "Parima, pachena, gara neni.<br><br>" +
                    "Handityi kana uri pedyo;<br>" +                    "Nhamu hairemi, handichemi:<br>" +                    "Handine nhamu naiko kufa.<br>" +                    "Ndokunda kana ugere neni.<br><br>" +
                    "Ndiratidze, Iwe uri woga;<br>" +                    "Ndivhenekere kuti ndione.<br>" +                    "Kuedza kunogouya zvino;<br>" +                    "Mu’penyu murufu, gara neni.<br>";
    String hymn64=
            "NGONI dzaKristu M’ponisi,<br>" +                    "Rudo rwaBaba vedu,<br>" +                    "Nokuwadzana koMweya,<br>" +                    "Kuve nesu kwedenga!<br>" +
                    "Sezvo tose togarisana<br>" +                    "Mumwe nomumwe, Ishe;<br>" +                    "Mwoyo yedu inofara,<br>" +                    "Nenguva dzose dzedu,<br>" +
                    "Amen.<br>";
    String hymn65=
            "NDIANI pane zamba<br>" +                    "Vafudzi vopfugama?<br><br>" +                    "Korus<br>" +                    "Ndiye Jesu zvoshamisa<br>" +
                    "Ndiye mambo wokudenga<br>" +                    "Topfugama kwaari,<br>" +                    "Mutunidzi ndiMwari.<br><br>" +                    "Ndiani ane nzara<br>" +
                    "Pasango ari oga?<br><br>" +                    "Ndiani akapfava<br>" +                    "Nedama rakanaka?<br><br>" +                    " Ndiani anorapa<br>" +
                    "Vose vanorwadziwa?<br><br>" +                    " Ndiani anochema<br>" +                    "“Razaru buda muguva”?<br><br>" +                    " Ndiani vokwazisa<br>" +
                    "Nedzimbo nokufara?<br><br>" +                    "Ndiani ateura<br>" +                    "Pausiku mumunda?<br><br>" +                    "Ndiani atifira<br>" +
                    "Pam’soro pam’chinjikwa?<br><br>" +                    "Ndiani anomuka<br>" +                    "Isu kutinunura?<br><br>" +                    " Ndiani pakudenga<br>" +
                    "Anotonga nesimba?<br>";
    String hymn66 =
            "MTSVENE , m’tsvene, m’tsvene!<br>" +                    "Mwari Samasimba!<br>" +                    "Tinomukumbira pamangwanani ese,<br>" +                    "M’tsvene, M’tsvene, m’tsvene,<br>" +
                    "Mune nyasha huru,<br>" +                    "Umwe vatatu pamwe chetezve!<br><br>" +                    "M’tsvene, m’tsvene, m’tsvene!<br>" +                    "Vese vanodaro,<br>" +
                    "Vakahwararira pamberi penyu Mwari:<br>" +                    "M’tsvene, m’tsvene, m’tsvene!<br>" +                    "Vanomunamata<br>" +                    "Mwakange muri, munozovazve!<br><br>" +
                    "M’tsvene, m’tsvene, m’tsvene!<br>" +                    "Hatizomuoni,<br>" +                    "Mbiri yenyu huru panyika nokudenga:<br>" +                    "M’tsvene, m’tsvene, m’tsvene!<br>" +
                    "Muri m’tsvene chete,<br>" +                    "Mwakanaka mwakachenazve!<br><br>" +                    "M’tsvene, m’tsvene, m’tsvene!<br>" +                    "Zvese zvakasikwa<br>" +
                    "Zvinokudza imwi, mukuru kune vese:<br>" +                    "M’tsvene, m’tsvene, m’tsvene!<br>" +                    "Mwakaruramisa,<br>" +                    "Mwari mupenyu nemusikizve!<br>";
    String hymn67=
            "TENZI , taungana muno mumba yenyu,<br>" +                    "Uyaiwo zvatapinda, Tenzi mberi<br>" +                   "Kweyu<br>" +                    "Iyo mwoyo yedu inomuchemera.<br>" +
                    "Neyi mweya yedu, Tenzi, inomutarira.<br><br>" +                    "Baba, ngatizive kuti muri pano<br>" +                    "Ngatirinzwe izwi renyu, razarurwa ndimi.<br>" +                    "Tigadzirireyi isu vanhu venyu,<br>" +
                    "Kuti tafa mutipinze kune musha wenyu.<br>";
    String hymn68=
            "BABA wedu mwakazviita,<br>" +                    "Mwakatipa Muponesi,<br>" +                    "Murumbwana wenyu umwe,<br>" +                    "Kuti atipangidzire<br>" +
                    "Nzira yekudenga renyu.<br><br>" +                    "Kuti tichikarakadza<br>" +                    "Ngevabari vedu kare,<br>" +                    "Vaitambudzika diko<br>" +
                    "Ngekushaya nguva yokudya<br>" +                    "Pfumvu, nhamo, nzara hayo.<br><br>" +                    "Havasaiziva Mwari<br>" +                    "Kana Murumbwana wake<br>" +
                    "Havasakamuombera,<br>" +                    "Vakagara mune dima<br>" +                    "Havasakaona mwenje.<br>" +                    "Zvino isu tinotenda<br><br>" +
                    "Tiri vana venyu Baba,<br>" +                    "Vanomuombera kwese,<br>" +                    "Uko tinofamba isu,<br>" +                    "Tine muchengeti, Jesu<br>";
    String hymn69=
            "Pausiku hweutsvene<br>" +                    "Kune nyika iri kure,<br>" +                    "Yakajeka nyeredzi yaTenzi,<br>" +                    "Chioniso chaMwari wediko<br>" +
                    "Iyo Tenzi wabarwa,<br>" +                    "Iyo kwabarwa Mesiya.<br><br>" +                    "Baba wake wakashama,<br>" +                    "Mai wake wakafara,<br>" +
                    "Mwana wavo M’ponesi wevanhu<br>" +                    "Wakakudzwa zvikuru ndiMwari.<br>" +                    "Pasi pese chifarai<br>" +                    "Mwari wazotishanyira.<br><br>" +
                    "Mune danga radzo n’ombe<br>" +                    "Wakabarwa mwana mutsva,<br>" +                    "Ndiye mwana waMwari mupenyu,<br>" +                    "Ndiye rudo rwaBaba kunesu.<br>" +
                    "Ndiye mudi wevanhu,<br>" +                    "Nemudikani wevese.<br>";
    String hymn70=
            "WATAKURA kuipa Jesu,<br>" +                    "Kusi kuipa kwenyu,<br>" +                    "Ukaripa mhosva Jesu,<br>" +                    "Isi mhosva, yako.<br><br>" +
                    "Waiva munhu une tsitsi,<br>" +                    "Usatadza iwe<br>" +                    "Raparara ropa rako,<br>" +                    "Wakanaka iwe.<br><br>" +
                    "Kudarika kwedu kwose<br>" +                    "kwakanyorwa newe,<br>" +                    "Nezvirandu zvedu zvose<br>" +                    "Zvakanyorwa newe.<br><br>" +
                    "Taregerwa taponiswa<br>" +                    "Nezvirwadzo zvako,<br>" +                    "Tinoshambwa pakaipa<br>" +                    "Nero ropa rako.<br>";

    String hymn71=
            "MWEYA M’tsvene muri Mwari,<br>" +                    "Ndinotambudzika,<br>" +                    "Mwoyo wangu unochema,<br>" +                    "Ndinomuda zvino.<br><br>" +
                    "Korus<br>" +                    "Ndizadzenyi, ndizadzenyi<br>" +                    "Uyai, Mweya zvino,<br>" +                    "Pindai mwoyo wangu, Mweya,<br>" +
                    "Kuti ndisimbiswe.<br><br>" +                    "Ndine nungo zviro kwazvo,<br>" +                    "Ndinoshaya simba,<br>" +                    "Asi mukandisimbisa,<br>" +
                    "Ndinokunda zvese.<br><br>" +                    "Ndinoziva basa renyu<br>" +                   "Kuti rakanaka,<br>" +                   "Munotungamira vese<br>" +
                    "Vanomuteera.<br><br>" +                    "Kuti ndichitungamirwa<br>" +                    "Handichawi pasi,<br>" +                    "Handichamusiyi Baba,<br>" +
                    "Kana nzira dzenyu.<br><br>" +                    "Nzira dzenyu dzakanaka,<br>" +                    "Dzine ruvheneko,<br>" +                    "Dzine zano rokufamba<br>" +
                    "Zvakanaka kwazvo.<br><br>" +                    "Muri mubatsiri wangu,<br>" +                    "Mutendeki kwaye,<br>" +                    "Avo vanomutevera<br>" +
                    "Vanokomborerwa.<br>";
    String hymn72=
            "MURAPI ari pano," +                    "<br> chiremba wokudenga,<br>" +                    "Wauya pasi pano <br>" +                    "korapa mwoyo yese.<br><br>" +
                    "Korus<br>" +                    "Zita rakanaka, " +                    "<br>ngatimuimbire,<br>" +                    "Ndwiyo dzeupenyu " +
                    "<br>Jesu Tenzi wangu.<br><br>" +                    "Zvitadzo anobvisa, <br>" +                    "izwanyi izwi rake,<br>" +                    "Fambanyi zvakanaka,<br>" +
                    " muite kuda kwake.<br><br>" +                    "Hapana rimwe zita <br>" +                    "kunaka kunga Jesu,<br>" +                    "Radzinga kutya kwangu,<br>" +
                    " ndokudza zita rake.<br><br>" +                    " Vacheche nepwere <br>" +                    "vanoda zita rake,<br>" +                    "Vanonzwa izwi rake,<br>" +
                    " vanoda basa rake.<br><br>" +                    "Uyanyi, vashamwari,<br>" +                    " kudzanyi zita rake,<br>" +                    "Tauranyi ngerurimi <br>" +
                    "zvikomborero zvake.<br><br>" +                    "Kudenga tikasvika,<br>" +                    " tichazoona Jesu,<br>" +                    "Nekuimbira Jesu,<br>" +
                    " navanhu vekudenga<br>";
    String hymn73=
            "URI Kutambudzikirenyiko?<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +                    "Muponesi anokuponesa,<br>" +                    "Zviudze Jesu nyamusi.<br><br>" +
                    "Korus:<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +                    "Ndiye shamwari nehama,<br>" +                    "Hakuchina umwe wakadro,<br>" +
                    "Zviudze Jesu nyamusi.<br><br>" +                    "Misorodzi ngeyenyiko hama?<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +                    "Munyaradzi anokunyaradza,<br>" +
                    "Zviudze Jesu pachako.<br><br>" +                    "Uri kutya dambudziko here?<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +                    "Uri kutya remangwana here?<br>" +
                    "Zviudze Jesu nyamusi.<br><br>" +                    "Uri kutya rufu here, iwe?<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +                    "Uyo Jesu, zviudze Jesu<br>" +
                    "Uyo wakakunda rufu rwake,<br>" +                    "Anozokupa rukundo.<br><br>" +                    "Unoshaya anotungamirira,<br>" +                    "Zviudze Jesu, zviudze Jesu,<br>" +
                    "Mweya M’tsvene ndiMutungamiri,<br>" +                    "Zviudze Jesu, nyamusi<br>";
    String hymn74=
            "WAGADZIRA nhasi here<br>" +                    "Nzwimbo yake Muponesi<br>" +                    "Yekugara mweya wake?<br>" +                    "Wakakumirira zvino.<br><br>" +
                    "Korus:<br>" +                    "Hunde ndine nzvimbo yake,<br>" +                    "Tenzi wevatenzi vese,<br>" +                    "Mwoyo wangu ndazarura<br>" +
                    "Kutambira Jesu Kristu.<br><br>" +                    "Mwari wakatisikira<br>" +                    "Kuva umba yekugara,<br>" +                    "Anotuma Mweya M’tsvene<br>" +
                    "Kuti azogara nesu.<br><br>" +                    "Une nzvimbo yake here,<br>" +                    "Uyo wakakununura?<br>" +                    "Apo wanga wakaraswa,<br>" +
                    "Wakauya kokutsvaka.<br><br>" +                    "Haunacho chipo kwete,<br>" +                    "Kupa kuna Mambo wako?<br>" +                    "Asi anofadzwa kwazvo<br>" +
                    "Kutambira mwoyo wako.<br><br>" +                    "Kuti uchimukanganwa,<br>" +                    "Ungazoponeswa senyi,<br>" +                    "Zvokusina rimwe zita<br>" +
                    "Reungaponeswa ndiro<br>";
    String hymn75=
            "NGERUTENDO rukuru,<br>" +                    "Ngerutendo rukuru,<br>" +
                    "Ngerutendo rukuru,<br>" +                    "Vanhu vanopona ndirwo.<br><br>" +                    "Rwakanakira Daniel.<br>" +
                    "Saka rwandinakira.<br><br>" +                    "Rwakanakira Pauro.<br><br>" +                    "Rwakanakira Pita.<br><br>" +                    "Rwakanakira Dorka.<br><br>" +
                    "Rwakanakira Ruthi.<br><br>" +                    "Rwakanditenderudza.<br><br>" +                    "Rwakandipa chisepe.<br><br>" +                    "Rwakandipa rukundo.<br><br>" +
                    "Rwakandipa kuziva.<br><br>" +                    "Rwakandipa ungwaru.<br><br>" +                    "Rwakandipa upenyu.<br><br>" +                    "Rwakandipa rufaro.<br><br>" +
                    "Runonditungamira.<br><br>" +                    "Runondipfawisisa.<br><br>" +                    "Runokwidza kudenga.<br>";
    String hymn76=
            "HAKUNA hama kupinda Jesu,<br>" +                    "Hakunaba, hakuchina.<br>" +                    "Hakuna umwe kurapa vese,<br>" +                    "Hakunaba, hakuchina.<br><br>" +
                    "Korus:<br>" +                    "Jesu ndiye shamwari yedu,<br>" +                    "Anonatsa kutungamira,<br>" +                    "Hakuna umwe kupinda Jesu,<br>" +
                    "Hakunaba, hakuchina.<br><br>" +                    "Hakuna mumwe mukuru zveba.<br>" +                    "Hakunaba, hakuchina.<br>" +                    "Hakuna umwe mununudziri,<br>" +
                    "Hakunaba, hakuchina.<br><br>" +                    "Hakuna chipo chikuru zveba,<br>" +                    "Hakunaba, hakuchina.<br>" +                    "Hakuna umwe kurapa mwoyo,<br>" +
                    "Hakunaba, hakuchina.<br><br>" +                    "Hakuna nguva tisingaonwi,<br>" +                    "Hakunaba, hakuchina.<br>" +                    "Hapana nzvimbo asingazivi,<br>" +
                    "Hakunaba, hakuchina.<br>";
    String hymn77=            "HAKUNA zita sera Jesu,<br>" +                    "Kana nokudenga,<br>" +                    "Hakuna rimwe rakadaro,<br>" +                    "Zita raM’ponesi.<br><br>" +
                    "Korus:<br>" +                    "Tinoda kuimbira Jesu,<br>" +                    "Tichimupa mbiri,<br>" +                    "Ngekuti hatizivi zita<br>" +
                    "Rinokunda iri.<br><br>" +                    "NdiJesu wakafira vese,<br>" +                    "Wakatida kwazvo,<br>" +                    "Zvotanga takaraswa zvedu.<br>" +
                    "Ngezvitadzo zvedu.<br><br>" +                    "NdiJesu wakaita nyasha,<br>" +                    "Takamukanganwa,<br>" +                    "Wakati, “Enda hako mwana,<br>" +
                    "Usazotadzazve.”<br><br>" +                    "NdiJesu wakatiudzira<br>" +                    "Kutunhidza Mwari<br>" +                    "Nekusarura vashamwari<br>" +
                    "Vakanaka chete<br><br>" +                    "NdiJesu wakarapa vanhu,<br>" +                    "Akavasimbisa,<br>" +                    "NdiJesu wakamutsa vafi<br>" +
                    "Kune hama dzavo.<br><br>" +                    "NdiJesu anoenda nesu<br>" +                    "Kwese tinoenda,<br>" +                    "NdiJesu anotibatsira<br>" +
                    "Muupenyu hwedu.<br>";
    String hymn78=
            "1.CHINYARARA , mwoyo wangu,<br>" +                    " Jesu ndiye Mwari,<br>" +                    "Zviro zvese zviri pasi<br>" +                    " Zvakasikwa ndiye.<br><br>" +
                    "Korus:<br>" +                    "Kristu uyanyi, <br>" +                    "Kristu uyanyi,<br>" +                    "Hunde, uyai, Tenzi.<br><br>" +
                    "2. Chinyarara, mwoyo wangu, <br>" +                    "Jesu Mambo kwaye,<br>" +                    "Unotenda kuna Mwari, <br>" +                    "Tenda kuna Jesu.<br><br>" +
                    "3. Chinyarara, mwoyo wangu, <br>" +                    "Unokomborerwa,<br>" +                    "Haugari nguva ndefu, <br>" +                    "Uchasvika denga.<br><br>" +
                    "4. Chinyarara, mwoyo wangu, <br>" +                    "Jesu anowaka<br>" +                    "Imba yako yakanaka <br>" +                    "Kune denga rake.<br><br>" +
                    "5. Chinyarara, mwoyo wangu,<br>" +                    " Jesu ndiye Mwari,<br>" +                    "Kuda kwake kwakanaka, <br>" +                    "Ngakuitwe ndiwe.<br>";
    String hymn79=
            "BABA wedu wakatsidza,<br>" +                    "“Ndinokutungamirira”<br>" +                    "Kuti usarasikeba<br>" +                    "Parwendo kune denga<br><br>" +
                    "Korus:<br>" +                    "“Ndinokutungamirira,”<br>" +                    "Ndinokutungamirira<br>" +                    "Pakukwira kune denga.<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Apo unotambudzika,<br>" +                    "Nekushaya zano zviya,<br>" +                    "Unofadzwa nge’ya mazwi,<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Kuti hama dzako dzafa,<br>" +                    "Uchidzichemera kwazvo,<br>" +                    "Unafunga aya mazwi,<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Apo unokomborerwa,<br>" +                    "Mwoyo wako unofara,<br>" +                    "Unadisa aya mazwi,<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Mangwana ese ese,<br>" +                    "Unokarakadza iye,<br>" +                    "Nechitsidzo chakanaka,<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Apo unobata basa,<br>" +                    "Unafunga mazwi ake<br>" +                    "Uyo wakakutsidzira,<br>" +
                    "“Ndinokutungamirira,”<br><br>" +                    "Apo unorara pasi,<br>" +                    "Paisiku uri wega,<br>" +                    "Unatenda aya mazwi,<br>" +
                    "“Ndinokutungamirira,”<br>";
    String hymn80=
            "ITAI , M’ponesi izvo munoda,<br>" +                    "Muri muumbi, ndiriwo dongo;<br>" +                    "Ndiumbei, Tenzi, sezvo munoda.<br>" +                    "Ndakamirira, ndakatiwira.<br><br>" +
                    "Itai, M’ponesi izvo munoda,<br>" +                    "Ndinangisenyi nekundiedza;<br>" +                    "Sukai mumwoyo, kuti ndichene,<br>" +                    "Ndizofanire denga kumusoro.<br><br>" +
                    "Itai, M’ponesi izvo munoda,<br>" +                    "Ndakakuvadzwa, ngandirapwe:<br>" +                    "Simba ngerenyu kuda ngekwenyu,<br>" +                    "Ngandisimbiswe Mwana waMwari.<br><br>" +
                    "Itai, M’ponesi izvo munoda,<br>" +                    "Pisai kuipa kotsai kunaka;<br>" +                    "Nditungamirenyi zvakarurama,<br>" +                    "Nditambirenyi, Tenzi, ndapota.<br><br>" +
                    "Itai, M’ponesi izvo munoda,<br>" +                    "Ndidzidzisenyi zvese zvaBaba;<br>" +                    "Ndigadzirenyi umba kumsoro,<br>" +                    "Ndoda kugara nemwi M’ponesi.<br>";
    String hymn81=
            "JESU , muri M’ponesi,<br>" +                    "Munopinda zviro zvese,<br>" +                    "Pakufamba kwangu kwese<br>" +                    "Ngandifambe nemwi, Tenzi;<br>" +
                    "Patyo nemwi, patyo nemwi,<br>" +                    "Patyo nemwi, patyo nemwi,<br>" +                    "Pakufamba kwangu kwese,<br>" +                    "Ngandifambe nemwi, Tenzi.<br>" +
                    "<br>" +                    "Handichadi ruzororo,<br>" +                    "Handichadi mari zhinji,<br>" +                    "Handichadi pfuma zhinji,<br>" +
                    "Ngandifambe nemwi, Tenzi;<br>" +                    "Patyo nemwi, patyo nemwi,<br>" +                    "Patyo nemwi, patyo nemwi,<br>" +                    "Handichadi pfuma zhinji,<br>" +
                    "Ngandifambe nemwi, Tenzi.<br>" +                    "<br>" +                    "Munditungamire, Tenzi,<br>" +                    "Pane nzira dzangu dzese,<br>" +
                    "Munditore muupenyu,<br>" +                    "Ngatifambe nemwi, Tenzi;<br>" +                    "Patyo nemwi, patyo nemwi,<br>" +                    "Patyo nemwi, patyo nemwi,<br>" +
                    "Munditore muupenyu,<br>" +                    "Ngatifambe nemwi, Tenzi.";
    String hymn82=
            "UNGATORA hako pasi<br>" +                    "Nerufaro rwapo rwese,<br>" +                    "Ndinotora hangu Jesu<br>" +                    "Nerufaro rwake rwese<br>" +
                    "<br>" +                    "Korus:<br>" +                    "Tsitsi dzake zhinjizhinji,<br>" +
                    "Dzinokwana kune vese,<br>" +                    "Ruponeso rwakakomba,<br>" +                    "Runofadza iwe neni.<br>" +                    "<br>" +                    "Ungatora hako pasi<br>" +                   "Neupfumi hwapo hwese,<br>" +
                    "Ndinofadzwa ndiye Jesu,<br>" +                    "Haazondinyimi chiro.<br>" +                    "<br>" +                    "Ungatora hako pasi<br>" +
                    "Nemichero inorwadza,<br>" +                    "Asi ini ndie nhaka<br>" +                    "Yeupenyu hwake Mwari.<br>" +                    "<br>" +
                    "Ungatora hako pasi<br>" +                    "Asi unofamba wega,<br>" +                    "Ini ndine Muponeso<br>" +                    "Ari Tenzi wakanaka.<br>" +
                    "<br>" +                    "Ungatora hako pasi<br>" +                    "Asi harugutsi mweya,<br>" +                    "Ndinotenda kuna Jesu<br>" +
                    "Uyo ane zano rese.<br>" +                    "<br>" +                    "Ungatora hako pasi<br>" +                   "Uchitadza uchichema,<br>" +
                    "Asi ndinofara kwazvo<br>" +                   "Ndine mubatsiri wangu.";
    String hymn83=
            "MWARI , Baba wangu,<br> Ndinoona vanhu<br>" +                    "Vakasiya nzira yenyu.<br> Vaari varasiki;<br>" +                    "Garai neni,<br> Garai neni<br>" +                    "Nekusingaperi.<br>" +
                    "<br>" +                    "Neupenyu hwangu <br>hwakatsonga kwazvo,<br>" +                    "Asi ndinotenda kuti <br>Munogara neni;<br>" +                    "Garai neni, <br>Garai neni<br>" +
                    "Nekusingaperi.<br>" +                    "<br>" +                    "Pasi pano pese, <br>Ndinoona kuti,<br>" +                    "Zviro zvese zvichapera, <br>Imwi munogara;<br>" +
                    "Garai neni,<br> Garai neni<br>" +                    "Nekusingaperi.<br>" +                    "<br>" +                    "Vanhu vanobarwa, <br>Ivo vanokura,<br>" +
                    "Asi kufa kuchauya,<br> Baba gara neni;<br>" +                    "Garai neni,<br> Garai neni<br>" +                    "Nekusingaperi.<br>" +                    "<br>" +
                    "Kuti ndichichema <br>Nematambudziko,<br>" +                    "Achapera ndichafara,<br> Baba, garai neni,<br>" +                    "Garai neni,<br> Garai neni<br>" +                    "Nekusingaperi.";
    String hymn84=
            " MUSANDIPFUURA  Jesu <br>Ndinochema ini<br>" +                    "Mukakomborera vamwe <br> Musandipfuure.<br>" +                    "<br>" +                    "Ndinotenda imwi  Jesu <br> Mwakandinunudza<br>" +
                    "Ndanga ndiri kufa ini<br> Muzvitema zvangu.<br>" +                    "<br>" +
                    "Ngandipiwe mwoyo m’chena <br>Wekumufarisa<br>" +                    "Ndinomukumbira Tenzi <br> Ngandikomborerwe.<br>" +                    "<br>" +
                    "Ngerunako rwenyu Jesu<br> Ndomutsvaka zvino<br>" +                    "Mwoyo wangu ngaurapwe<br> Ndoda kuponeswa.<br>" +                    "<br>" +
                    "Ropa renyu ngarikudzwe<br> Rindishambe nhasi,<br>" +                    "Muri mununuri imwi<br> Mwakandinunura.<br>" +                    "<br>" +
                    "Muri tsime yeupenyu <br>Nerufaro rwese,<br>" +                    "Ngandiinwe iyi tsime<br> Ndine nyota huru.<br>" +                    "<br>" +
                    "Imwi munonyararidza <br>Mwoyo wangu uyu,<br>" +                    "Pasi pano nokudenga<br> Muri Tenzi wangu.";
    String hymn85=
            "MUZUNDE renyu, Baba,<br>" +                    "Mune basa rekuita,<br>" +                    "Vanhu havazivi imwi,<br>" +                    "Vanogara mune dima,<br>" +
                    "Havazivi nzira tsvene,<br>" +                    "Havazivi Jesu Kristu,<br>" +                    "Murumbwana wenyu chete,<br>" +                    "Havazivi rudo rwenyu.<br><br>" +
                    "Korus:<br>" +                    "Ndiri pano, Tenzi nditumenyi<br>" +                   "Kune avo vanoshaya.<br><br>" +                    "Ndiri pano nditumenyi<br>" +
                    "Kune avo vanoshaya,<br>" +                    "Mudikani, Tenzi wangu,<br>" +                    "Soko renyu ndingatora,<br>" +                    "Kana vanhu vandivenga,<br>" +
                    "Sezvo imwi mwakavengwa,<br>" +                    "Kuti muchindituma’yo<br>" +                    "Ndingafara kushandira.<br><br>" +                    "Taurai, Tenzi, soko renyu,<br>" +
                    "Taurai, Tenzi, ndiri kuzwa,<br>" +                    "Kuda kwenyu ngakuitwe<br>" +                    "Sezvo munondiudzira,<br>" +                    "Ndiudzirei mazwi enyu<br>" +
                    "Kuti ndipe kune vanhu,<br>" +                    "Ndiudzirei mazwi enyu,<br>" +                    "Enyu basi, Tenzi wangu.<br><br>" +                    "Kuti muchienda neni,<br>" +
                    "Kuti muchindisimbisa,<br>" +                    "Handizotyi madambudzo.<br>" +                    "Kana basa richikonja;<br>" +                    "Mwakatsidza kuva neni<br>" +
                    "Kuti ndichagara nemwi;<br>" +                    "Munamato wangu ndiwo,<br>" +                    "“Ndiri pano nditumenyi.”<br>";
    String hymn86=
            "ZANO chiro chakanaka,<br>" +                    "Tese tinorida kwazvo,<br>" +                    "Zano haritengwi, kwete,<br>" +                    "Riri chipo chaJehovha.<br><br>" +
                    "Izwi rake rine zano<br>" +                    "Kusimudza vanhu vese,<br>" +                   "Riri simba remarudzi,<br>" +                    "Riri idi remakore.<br><br>" +
                    "Nge’ro zano tine simba<br>" +                    "Rekuita zvakanaka,<br>" +                    "Asi rinouya basi<br>" +                    "Kune avo vanomuda.<br><br>" +
                    "Soromoni wakarida,<br>" +                    "Akarikumbira Mwari,<br>" +                    "Ndizvo Mwari wakamupa<br>" +                    "Zano, pfuma, nerukudzo.<br><br>" +
                    "Apo tinoshaya zano<br>" +                    "Ngatiuye kuna iye<br>" +                    "Uyo ane rakakwana,<br>" +                    "Kupa kune vanhu vese.<br>";
    String hymn87=
            "KWANGA kune m’kadzi kare<br>" +                    "Zita rake Dorka,<br>" +                    "Wakanga akanaka diko,<br>" +                    "Vese vakamuda.<br><br>" +
                    "Nemabhachi wakaruka<br>" +                    "Zvipo zvevarombo<br>" +                    "Wakadisa vanhu vese,<br>" +                    "Vese vakaziva.<br><br>" +
                    "Kuvarombo nevarwere<br>" +                    "Dorka waienda,<br>" +                    "Wakateurira ivo,<br>" +                    "Akavapa zvipo.<br><br>" +
                    "Kuti tine Mweya M’tswene,<br>" +                    "Tinodisa vese,<br>" +                    "Tinofara kubatsira<br>" +                    "Vese vanoshaya.<br>";
    String hymn88=
            "APO toropito yake Mwari inorira kwazvo,<br>" +                    "Inotaura kune vese kuti “Uyai”<br>" +                    "Tese tinobvira kuenda iyo hakusari munhu,<br>" +
                    "Nemazita edu achazodaidzwa.<br><br>" +                    "Korus:<br>" +                    "Kuti ndodaidzwa ndiye,<br>" +                    "Kuti ndodaidzwa ndiye,<br>" +
                    "Kuti ndodaidzwa ndiye,<br>" +                    "Kuti ndodaidzwa ndiye, ndova’yo<br><br>" +                    "Asi hatizivi musi uyo tichadanwa ndiwo,<br>" +                   "Ndizvo ngatigadzirire zvino pano,<br>" +
                    "Tirindire uyo musi tizonatsa kuenda iyo,<br>" +                    "Nemazita edu achazodaidzwa.<br><br>" +                    "Ngatibate basa redu nemasimba misi yese,<br>" +                    "Ngatitaure zvishamiso zvake zvese,<br>" +
                    "Tichiita zvakanaka kune vanhu vese vese,<br>" +                    "Nemazita edu achazodaidzwa.<br><br>" +                    "Asi isu wemaKristru hatizotyi kuenda iyo,<br>" +                    "Mwari ndiye Baba wedu wakanaka,<br>" +
                    "Jesu Kristu ndishamwari, ndiye anotonga vese,<br>" +                    "Nemazita edu achazodaidzwa.<br>";
    String hymn89=
            "NDOFAMBA , ndofamba, ndosuva kudenga,<br>" +                    "Kunyika yaTenzi, isina nenhamu.<br><br>" +                    "Fambanyi vatendi, kunyika kureyo,<br>" +                    "Inoda vasimbi kusvika’yo nyika.<br><br>" +
                    "Upfumi huriyo, hakuna murombo,<br>" +                    "Hakuna neumwe, neumwe hakuna.<br><br>" +                    "Madzinza ariyo kunyika yaTenzi<br>" +                    "Havachazochemi, havana rusuvo.<br><br>" +
                    "Vatsvene variyo, vafara zvikuru,<br>" +                   "Vaona’yo Nyenye, Mufiri wevese<br>";
    String hymn90=
            "APO Jesu anouya kotora varume,<br>" +                    "Anotora vakanaka, avo vanomuda.<br><br>" +                    "Korus:<br>" +                    "Vanhu vake vatsvene, vasine zvitema<br>" +
                    "Vanotenda kudenga kugara naJesu.<br><br>" +                    "Apo Jesu anouya kotora vakadzi,<br>" +                    "Anotora vakanaka, avo vanomuda.<br><br>" +                    "Apo Jesu anouya kotora vacheche,<br>" +
                    "Anotora vakanaka avo vanomuda.<br><br>" +                    "Vana vake pasi pano, uyanyi kwaari,<br>" +                    "Anomuda zvirokwazvo ngerudo rukuru.<br><br>" +                    " Ngatiedze misi yese kufadza M’ponesi,<br>" +
                    "Kuti tizotorwa ndiye kudenga kumsoro.<br>";
    String hymn91=
            "HATINA musha panyika,<br>" +                    "Hatifari kuva pano,<br>" +                    "Zvinofadza mweya yedu<br>" +                    "Kutsvaka musha unouya.<br><br>" +
                    "Hatinamusha panyika,<br>" +                    "Tinoda musha uri kure,<br>" +                    "Zita rawo iZioni<br>" +                    "Unopenya nguva dzese.<br><br>" +
                    "Musha une runyararo<br>" +                    "Vafambi vachazorora,<br>" +                    "Dai ndine mapapiro,<br>" +                    "Ndaiuya ndizorore.<br><br>" +
                    "Mweya wangu Chinyarara<br>" +                    "Mwari Anoziva nguva,<br>" +                    "Ndichaita kuda kwake,<br>" +                    "Iye wondipa zororo.<br>";
    String hymn92=
            "Chinjikano ndirero<br>" +                    "Tsime rweupenyu;<br>" +                    "Rinopodza vose<br>" +
                    "She vanouya kwenyu.<br><br>" +                    "Korus:<br>" +                    "Ipapo, Ipapo, Jesu ndichakudza;<br>" +                    "Kusvikira ikweyo ndichimurumbiza.<br><br>" +                    "Chinjikano, ipapo<br>" +
                    "Ndanga ndichihuta;<br>" +                   "Bva nenyasha ndipapo<br>" +                    "Pandakazofara.<br><br>" +                    "Maratidza ipapo<br>" +                    "Tsitsi dzenyu huru;<br>" +
                    "Zvino mundibetserei<br>" +                    "Kuifunga kwazvo!<br><br>" +                    "Ndorambira ipapo,<br>" +                    "Ndichitenda kwoga;<br>" +
                    "Pamwe handizivi’po.<br>" +                    "Asi apo poga.<br>";
    String hymn93=
            "Ndinosimuda SHE,<br>" +                    "Kundibetsera,<br>" +
                    "Nzwi renyu ndigonzwa<br>" +                    "Kundinyaradza.<br><br>" +
                    "Korus:<br>" +                    "Ndotsvaka imi moga,<br>" +                    "Mwoyo wangu womushuva<br>" +
                    "Nditaririre Jesu,<br>" +                    "Ndinyaradzei!<br><br>" +                    "Ndinosimuda, SHE!<br>" +
                    "Sarai neni;<br>" +                    "Ndingazokunda vo<br>" +                    "Muri pandiri!<br><br>" +
                    "Ndinosimuda, SHE!<br>" +                    "Pandinofara;<br>" +                    "Pandotambura vo,<br>" +                    "Musandisiya!<br><br>" +
                    "Ndinosimuda, SHE!<br>" +                    "Ndinatswe chose;<br>" +                    "Ndimushumire vo<br>" +
                    "Nomwoyo wose!<br>";
    String hymn94=
            "Tarirai kune nyika uko!<br>" +                    "Nokutenda tovona iyo<br>" +                    "Bambo vedu vanogarapo,<br>" +                    "Vachingogadzirira isu<br><br>" +
                    "Korus:<br>" +                    "Tichando farawo,<br>" +                    "Musi watichazosvika ko<br>" +                    "Tichando, tichando farawo,<br>" +
                    "Musi watichazosvikako.<br><br>" +                    "Tichazondoimbira apo;<br>" +                    "Nziyo dzavadikanwa vashe;<br>" +                    "Mweya yedu ichafara vo,<br>" +
                    "Ichingozorodziwa naye.<br><br>" +                    "Tichandovunganira apo,<br>" +                    "Tichandokudza zita raShe;<br>" +                    "Nyasha yake tichavonga vo,<br>" +
                    "Tazopiwa zororo naye.<br>";
    String hymn95=
            "Mambo Jesu watidaidza<br>" +                    "Kuchidyo chake chokudenga<br>" +                    "Tomira sei pakutongwa<br>" +                    "Mambo apinda.<br><br>" +
                    "Korus<br>" +                    "Apo Mambo apinda, kuzotitonga<br>" +                    "Tinomira sei apo, Mambo apinda.<br><br>" +                    "Mambo Jesu ane chiremba<br>" +
                    "Pakange pazoiswa minzwa<br>" +                    "Nembiri yake tichaona<br>" +                   "Mambo apinda.<br><br>" +                    "Zvakaipa zvichaonekwa<br>" +
                    "Kuti tamira pakutongwa<br>" +                    "Zvemumoyo zvichaonekwa<br>" +                    "Mambo apinda.<br><br>" +                    "Achafara pakutiona, kuti tapfeka<br>" +
                    "Nguwo Chena<br>" +                    "Ndizvo kunesu kunonaka<br>" +                    "Mambo apinda.<br><br>" +                    "Tenzi tinokuimbira mutsa<br>" +
                    "Kuti tose tigozomira<br>" +                    "Munzvimbo dzedu nokusatya<br>" +                    "Mambo apinda.<br>";
    String hymn96=
            "Dyara Mangwanani, mbeu dzakanana<br>" +                    "Dyara masikati namadekwana<br>" +                    "Vakushi vashoma, pabasa raMwari<br>" +                    "Tinodanwa tose, pabasa raIshe.<br><br>" +
                    "Korus:<br>" +                    "Huyai navo huyai navo<br>" +                    "Vanhu varasiki, tivadzosere<br>" +                    "Huyai navo, huyai navo<br>" +
                    "Vanhu varasiki tivadzosere.<br><br>" +                    "Mbeu tinodyara, ndiro shoko raShe<br>" +                    "Rinotidzidzisa nzira dzedenga<br>" +                    "Rinotiradzawo Jesu somuponisi<br>" +
                    "Vatadzi vese vari murima.<br><br>" +                    "Tiende tidyare, tirege kuzeza<br>" +                    "Zuva rinouya tichazorora<br>" +                    "Tichapiwa tose mubairo yedu<br>" +
                    "Tichafara tose nokufarawo.<br><br>" +                    " Varipo vazhinji vanofamba zvavo<br>" +                    "Havana kuudzwa zvomuponisi<br>" +                    "Isu Vanyai vashe, takapiwa basa<br>" +
                    "Kudzosera vese vari murima.<br>";



    String names[] = {"1. Imi mose muri pasi","2. Mwari muri zuva redu","3. Ngatimukudzei Mwari",
            "4. Mukudzei iye Mwari","5. Jehovha una masimba","6. Wakasika zvose zvinhu","7. Ndinoshamiswa kwazvo","8. Zadzisa chirevo chako",
            "9. Hosana wokudenga","10. Mununuri wedu","11. Watakura kuipa Jesu","12. Tsitsi hedzi dzamira dzoga","13. Ngatitende kuna Jesu","14. Changamire muponisi","15. N'anga huru yava pedyo",
            "16. Tine chipo chakakomba","17. Kristu wamuka nhasi","18. Ndinobva kwamuri","19. Mweya Mutsvene waMwari","20. Simudzai kufunga kwedu","21. Tine dama rako Mwari","22. Dzidzisai vadzidzisi",
            "23. Riripo tsime rizere","24. Paimba yeGwayana raMwari","25. Ishe ndinzwe nokufara","26. Ndinochema Ishe Mwari","27. Jesu ndanga ndakurasa","28. Uya mwoyo wangu","29. Baba ndiri mwana wako",
            "30. Rakanaka iro zuva","31. Una vanhu vako Mwari","32. Mweya wangu uno Muponisi","33. Tirivawadzani","34. Fambai vatendi","35. Ndanzwa Inzwi Rako","36. Vazhinji vanayo nhaka","37. Ngandibereke mapudzi",
            "38. Mufudzi ndiye Jehovha","39. Nditarire nokufara","40. Nditungamire Jehovha","41. Ishe Taungana","42. Zvatapinda Ishe wedu", "43. Famba mangwanangwana","44. Wakatora chipapata","45. Kwasara makore","46. Wauya mucheki mukuru",
            "47. Mumhanzi uri kudenga","48. Chinhu chinotyisa kwazvo","49. Pamusoro pakudenga","50. Pakudenga kuna Baba","51. Dombondipa meso ndione","52. Jerusarema musha wangu","53. Nzvimbo yakanaka",
            "54. Nguva yakanakisa","55. Amai navana","56. Ndiropafadze Jesu","57. Jesu unoshevedza vaduku","58. Nhasi ndinofara","59. Chiriko chikomo kure",
            "60. Mumwe ariko pam’soro","61. Mangwanana zvinhu zvose","62. Mumwe musi ava mauro","63. Gara neni izuva radoka","64. Ngoni dzaKristu M'ponisi","65. Ndiani pane zamba","66. Mtsvene","67. Tenzi taungana","68. Baba wedu mwakazviita",
            "69. Pausiku hweutsvene","70. Watakura kuipa Jesu","71. Mweya mutsvene muri Mwari","72. Murapi ari pano","73. Uri Kutambudzikirenyiko?",
            "74. Wagadzira nhasi here","75. Ngerutendo rukuru","76. Hakuna hama kupinda Jesu","77. Hakuna zita sera Jesu","78. Chinyarara mwoyo wangu","79. Baba wedu wakatsidza","80. Itai m’ponesi izvo munoda",
            "81. Jesu muri M’ponesi","82. Ungatora hako pasi","83. Mwari Baba wangu","84. Musandipfura Jesu","85. Muzunde renyu Baba",
            "86. Zano chiro chakanaka","87. Kwanga kune m’kadzi kare","88. Apo toropito yake Mwari","89. Ndofamba ndofamba","90. Apo Jesu anouya","91. Hatina musha panyika","92. Chinjikano ndirero",
            "93. Ndinosimuda SHE","94. Tarirai kune nyika uko","95. Mambo Jesu watidaidza","96. Dyara mangwanani"};
    String desc[]={hymn1,hymn2,hymn3,hymn4,hymn5,hymn6,hymn7,hymn8,hymn9,hymn10,hymn11,hymn12,hymn13,hymn14,hymn15,hymn16,hymn17,hymn18,hymn19,hymn20
            ,hymn21, hymn22,hymn23,hymn24,hymn25,hymn26,hymn27,hymn28,hymn29,hymn30,hymn31,hymn32,hymn33,hymn34,hymn35,hymn36,hymn37,hymn38,hymn39,hymn40,
            hymn41,hymn42,hymn43,hymn44,hymn45,hymn46,hymn47,hymn48,hymn49,hymn50,hymn51,hymn52,hymn53,hymn54,hymn55,hymn56,hymn57,hymn58,hymn59,hymn60,
            hymn61,hymn62,hymn63,hymn64,hymn65,hymn66,hymn67,hymn68,hymn69,hymn70,hymn71,hymn72,hymn73,hymn74,hymn75,hymn76,hymn77,hymn78,hymn79,hymn80,
            hymn81,hymn82,hymn83,hymn84,hymn85,hymn86,hymn87,hymn88,hymn89,hymn90,hymn91,hymn92,hymn93,hymn94,hymn95,hymn96};

    List<ItemsModel> listItems = new ArrayList<>();

    SavePref savePref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        savePref = new SavePref(getContext());
        if(savePref.loadNightModeState()){
            getActivity().setTheme(R.style.darkTheme);
        }
        else getActivity().setTheme(R.style.AppTheme);
        setHasOptionsMenu(true);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shona, container, false);
        listView = view.findViewById(R.id.listview);
        //CustomAdapter projectListAdapter = new CustomAdapter();
        TextView empty=(TextView)view.findViewById(R.id.empty);
        listView.setEmptyView(empty);
//        Toolbar toolbar = view.findViewById(R.id.toolbar);
//        toolbar.getMenu().findItem(R.id.search_view);



        for(int i = 0; i < names.length; i++){
            ItemsModel itemsModel = new ItemsModel(names[i],desc[i]);
            listItems.add(itemsModel);
        }
        customAdapter = new CustomAdapter(listItems,this);
        listView.setAdapter(customAdapter);

        return view;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                customAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search_view){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<ItemsModel> itemsModelsList;
        private List<ItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemsModel> itemsModelsList, Shona context) {
            this.itemsModelsList = itemsModelsList;
            this.itemsModelListFiltered = itemsModelsList;
             this.context = getContext();
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_item,null);
            TextView itemName = view.findViewById(R.id.itemName);
//            TextView itemDisc = view.findViewById(R.id.itemDesc);


            itemName.setText(itemsModelListFiltered.get(position).getName());
//            itemDisc.setText(itemsModelListFiltered.get(position).getDesc());

            //onclick listener
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // startActivity(new Intent(Shona.this, itemViewActivity.class).putExtra("item",itemsModelListFiltered.get(position)));
                    Intent intent = new Intent(getActivity(), itemViewActivity.class).putExtra("item",itemsModelListFiltered.get(position));
                    startActivity(intent);
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter(){

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.toString().length() == 0){
                        filterResults.count = itemsModelsList.size();
                        filterResults.values = itemsModelsList;
                    }else{
                        String searchStr = constraint.toString().toLowerCase();
                        List<ItemsModel> resultData = new ArrayList<>();

                        for(ItemsModel itemsModel:itemsModelsList){
                            //making filter case insensitive
                            if(itemsModel.getName().toString().toLowerCase().contains(searchStr) ){
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered = (List<ItemsModel>) results.values;
                    notifyDataSetChanged();

                }
            };
            return filter;
        }
    }
}