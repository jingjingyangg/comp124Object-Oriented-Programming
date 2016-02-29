package edu.macalester.comp124.hw6;

import org.wikapidia.conf.ConfigurationException;
import org.wikapidia.core.dao.DaoException;
import org.wikapidia.core.lang.Language;
import org.wikapidia.core.model.LocalPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Analyzes the overlap in popular concepts.
 * Experimental code for Shilad's intro Java course.
 * Note that you MUST correct WikAPIdiaWrapper.DATA_DIRECTORY before this works.
 *
 * @author Shilad Sen
 */
public class PopularArticleAnalyzer {
    private final WikAPIdiaWrapper wpApi;

    /**
     * Constructs a new analyzer.
     * @param wpApi
     */
    public PopularArticleAnalyzer(WikAPIdiaWrapper wpApi) {
        this.wpApi = wpApi;
    }

    /**
     * Returns the n most popular articles in the specified language.
     * @param language
     * @param n
     * @return
     */
    public List<LocalPage> getMostPopular(Language language, int n) {

        List<LocalPage> allLocalPages = wpApi.getLocalPages(language);
        List<LocalPagePopularity> popularities = new ArrayList<LocalPagePopularity>();
        for (LocalPage page:allLocalPages){
            LocalPagePopularity popularity = new LocalPagePopularity(page,wpApi.getNumInLinks(page));
            popularities.add(popularity);
        }

        Collections.sort(popularities);
        Collections.reverse(popularities);
        List<LocalPage> topN = new ArrayList<LocalPage>();
        for (int i = 0; i < n; i++){
            LocalPage page = popularities.get(i).getPage();
            topN.add(page);
        }
        return topN;
    }

    public static void main(String args[]) {
        Language simple = Language.getByLangCode("simple");
        // Change the path below to point to the parent directory on the lab computer
        // or laptop that holds the BIG "db" directory.
        WikAPIdiaWrapper wrapper = new WikAPIdiaWrapper();
        // TODO: Complete me for part 1.
        // construct a PopularArticleAnalyzer
        PopularArticleAnalyzer analyzer = new PopularArticleAnalyzer(wrapper);
        // Print out the 20 most popular articles in the language.
        List<LocalPage> list = analyzer.getMostPopular(simple,20);
        // United states should be #1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
