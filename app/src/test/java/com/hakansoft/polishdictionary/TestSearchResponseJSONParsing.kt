package com.hakansoft.polishdictionary

import com.google.gson.Gson
import org.junit.Test
import org.junit.Assert.*

class TestSearchResponseJSONParsing {
    @Test
    fun parse_search_response_kraj() {
        val jsonResponse = "{\"total_entries_found\":\"4\",\"total_pages_found\":1,\"current_page\":0,\"current_page_size\":20,\"current_entries_found\":4,\"has_next_page\":false,\"next_page\":1,\"found_as\":\"kraj\",\"user_search_string\":\"kraj\",\"search_model\":\"chomper\",\"results\":[{\"id\":\"10707\",\"headword\":\"kraj\",\"embedded_definition\":\"<strong>kraj<\\/strong><em> mi <\\/em>country, nation, land\\r\",\"crossreferences\":\"\",\"rank\":\"41\",\"highlights\":\"<strong><span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">kraj<\\/span><\\/strong><em> mi <\\/em>country, nation, land\\r\"},{\"id\":\"10708\",\"headword\":\"kraja\\u0107\",\"embedded_definition\":\"<strong>kraja\\u0107<\\/strong><em> \\u2011j\\u0119 \\u2011jesz impf <\\/em>slice<strong>. ~ si\\u0119 <\\/strong>be cut. <strong>serce mu si\\u0119 kraja\\u0142o <\\/strong>his heart was breaking. <em>see also kroi\\u0107<\\/em>\\r\",\"crossreferences\":\"kroi\\u0107\",\"rank\":\"1445\",\"highlights\":\"<strong>kraja\\u0107<\\/strong><em> \\u2011j\\u0119 \\u2011jesz impf <\\/em>slice<strong>. ~ si\\u0119 <\\/strong>be cut. <strong>serce mu si\\u0119 kraja\\u0142o <\\/strong>his heart was breaking. <em>see also kroi\\u0107<\\/em>\\r\"},{\"id\":\"11768\",\"headword\":\"li\",\"embedded_definition\":\"<strong>li<\\/strong><em> old fash <\\/em>interrog <em>postpositional particle <\\/em><strong>znasz li ten kraj? <\\/strong>do you know that country? <em>(Mickiewicz)<\\/em>\\r\",\"crossreferences\":\"\",\"rank\":\"189812\",\"highlights\":\"<strong>li<\\/strong><em> old fash <\\/em>interrog <em>postpositional particle <\\/em><strong>znasz li ten <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">kraj<\\/span>? <\\/strong>do you know that country? <em>(Mickiewicz)<\\/em>\\r\"},{\"id\":\"32201\",\"headword\":\"wolny\",\"embedded_definition\":\"<strong>wolny<\\/strong><em> aj<\\/em> 1 free. <strong>~ czas<\\/strong> leisure time. <strong>~ kraj<\\/strong> free country. not occupied. <strong>~ st\\u00f3\\u0142<\\/strong> free table. unengaged, unattached, not busy. not married, eligible. <em>av <\\/em><strong>wolno <\\/strong><em>or <\\/em><strong>powoli<\\/strong> slowly\\r\",\"crossreferences\":\"\",\"rank\":\"316\",\"highlights\":\"<strong>wolny<\\/strong><em> aj<\\/em> 1 free. <strong>~ czas<\\/strong> leisure time. <strong>~ <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">kraj<\\/span><\\/strong> free country. not occupied. <strong>~ st\\u00f3\\u0142<\\/strong> free table. unengaged, unattached, not busy. not married, eligible. <em>av <\\/em><strong>wolno <\\/strong><em>or <\\/em><strong>powoli<\\/strong> slowly\\r\"}]}"

        checkParsedResponse(jsonResponse)
    }

    @Test
    fun parse_search_response_increase() {
        val jsonResponse = "{\"total_entries_found\":\"12\",\"total_pages_found\":1,\"current_page\":0,\"current_page_size\":20,\"current_entries_found\":12,\"has_next_page\":false,\"next_page\":1,\"found_as\":\"increase\",\"user_search_string\":\"increase\",\"search_model\":\"chomper\",\"results\":[{\"id\":\"14430\",\"headword\":\"narosn\\u0105\\u0107\",\"embedded_definition\":\"<strong>narosn\\u0105\\u0107<\\/strong><em> \\u2011rosn\\u0119 \\u2011\\u015bniesz \\u2011r\\u00f3s\\u0142 \\u2011ros\\u0142a \\u2011ro\\u015bli pf, impf <\\/em><strong>narasta\\u0107<\\/strong> grow, increase, accrue. build up. <em>impf only<\\/em> be on the rise\\r\",\"crossreferences\":\"\",\"rank\":\"16082\",\"highlights\":\"<strong>narosn\\u0105\\u0107<\\/strong><em> \\u2011rosn\\u0119 \\u2011\\u015bniesz \\u2011r\\u00f3s\\u0142 \\u2011ros\\u0142a \\u2011ro\\u015bli pf, impf <\\/em><strong>narasta\\u0107<\\/strong> grow, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, accrue. build up. <em>impf only<\\/em> be on the rise\\r\"},{\"id\":\"20939\",\"headword\":\"pot\\u0119gowa\\u0107\",\"embedded_definition\":\"<strong>pot\\u0119gowa\\u0107 (si\\u0119)<\\/strong><em> \\u2011guj\\u0119 \\u2011jesz impf, pf <\\/em><strong>spot\\u0119gowa\\u0107 (si\\u0119) <\\/strong>increase, intensify, heighten, come to the fore \\r\",\"crossreferences\":\"\",\"rank\":\"12059\",\"highlights\":\"<strong>pot\\u0119gowa\\u0107 (si\\u0119)<\\/strong><em> \\u2011guj\\u0119 \\u2011jesz impf, pf <\\/em><strong>spot\\u0119gowa\\u0107 (si\\u0119) <\\/strong><span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, intensify, heighten, come to the fore \\r\"},{\"id\":\"22602\",\"headword\":\"przybra\\u0107\",\"embedded_definition\":\"<strong>przybra\\u0107<\\/strong><em> \\u2011bior\\u0119 \\u2011bierzesz pf, impf <\\/em><strong>przybiera\\u0107 <\\/strong>take on, adopt, assume, increase, grow. <strong>~ na wadze <\\/strong>put on weight. <strong>~ na sile <\\/strong>gain strength\\r\",\"crossreferences\":\"\",\"rank\":\"7889\",\"highlights\":\"<strong>przybra\\u0107<\\/strong><em> \\u2011bior\\u0119 \\u2011bierzesz pf, impf <\\/em><strong>przybiera\\u0107 <\\/strong>take on, adopt, assume, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, grow. <strong>~ na wadze <\\/strong>put on weight. <strong>~ na sile <\\/strong>gain strength\\r\"},{\"id\":\"22611\",\"headword\":\"przyby\\u0107\",\"embedded_definition\":\"<strong>przyby\\u0107<\\/strong><em> \\u2011b\\u0119d\\u0119 \\u2011b\\u0119dziesz \\u2011b\\u0105d\\u017a pf, impf <\\/em><strong>przybywa\\u0107<\\/strong> arrive, reach a destination. <em>3p <\\/em>+<em>G<\\/em> increase. <strong>~ wody<\\/strong> the water is rising\\r\",\"crossreferences\":\"\",\"rank\":\"2335\",\"highlights\":\"<strong>przyby\\u0107<\\/strong><em> \\u2011b\\u0119d\\u0119 \\u2011b\\u0119dziesz \\u2011b\\u0105d\\u017a pf, impf <\\/em><strong>przybywa\\u0107<\\/strong> arrive, reach a destination. <em>3p <\\/em>+<em>G<\\/em> <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>. <strong>~ wody<\\/strong> the water is rising\\r\"},{\"id\":\"22784\",\"headword\":\"przymno\\u017cy\\u0107\",\"embedded_definition\":\"<strong>przymno\\u017cy\\u0107<\\/strong><em> \\u2011\\u017c\\u0119 \\u2011\\u017cysz \\u2011mn\\u00f3\\u017c impf<\\/em> add to, multiply, increase\\r\",\"crossreferences\":\"\",\"rank\":\"103084\",\"highlights\":\"<strong>przymno\\u017cy\\u0107<\\/strong><em> \\u2011\\u017c\\u0119 \\u2011\\u017cysz \\u2011mn\\u00f3\\u017c impf<\\/em> add to, multiply, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>\\r\"},{\"id\":\"24242\",\"headword\":\"rozmno\\u017cy\\u0107\",\"embedded_definition\":\"<strong>rozmno\\u017cy\\u0107<\\/strong><em> \\u2011\\u017c\\u0119 \\u2011\\u017cysz \\u2011mn\\u00f3\\u017c pf, impf <\\/em><strong>rozmna\\u017ca\\u0107 <\\/strong><em>trans <\\/em>propagate, procreate, increase, multiply. <em>intrans <\\/em><strong>~ si\\u0119<\\/strong> propagate o.s., multiply\\r\",\"crossreferences\":\"\",\"rank\":\"31944\",\"highlights\":\"<strong>rozmno\\u017cy\\u0107<\\/strong><em> \\u2011\\u017c\\u0119 \\u2011\\u017cysz \\u2011mn\\u00f3\\u017c pf, impf <\\/em><strong>rozmna\\u017ca\\u0107 <\\/strong><em>trans <\\/em>propagate, procreate, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, multiply. <em>intrans <\\/em><strong>~ si\\u0119<\\/strong> propagate o.s., multiply\\r\"},{\"id\":\"30616\",\"headword\":\"urosn\\u0105\\u0107\",\"embedded_definition\":\"<strong>urosn\\u0105\\u0107<\\/strong><em> \\u2011sn\\u0119 \\u2011\\u015bniesz pf, impf <\\/em><strong>urasta\\u0107 <\\/strong>grow, swell, increase \\r\",\"crossreferences\":\"\",\"rank\":\"6346\",\"highlights\":\"<strong>urosn\\u0105\\u0107<\\/strong><em> \\u2011sn\\u0119 \\u2011\\u015bniesz pf, impf <\\/em><strong>urasta\\u0107 <\\/strong>grow, swell, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span> \\r\"},{\"id\":\"34022\",\"headword\":\"wzmo\\u017cenie\",\"embedded_definition\":\"<strong>wzmo\\u017cenie<\\/strong><em> n <\\/em>increase, intensification\\r\",\"crossreferences\":\"\",\"rank\":\"24515\",\"highlights\":\"<strong>wzmo\\u017cenie<\\/strong><em> n <\\/em><span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, intensification\\r\"},{\"id\":\"34024\",\"headword\":\"wzm\\u00f3c\",\"embedded_definition\":\"<strong>wzm\\u00f3c<\\/strong><em> \\u2011mog\\u0119 \\u2011mo\\u017cesz \\u2011m\\u00f3g\\u0142 \\u2011mog\\u0142a pf, impf <\\/em><strong>wzmaga\\u0107<\\/strong> heighten. <strong>~ si\\u0119<\\/strong> increase, intensify, take on strength\\r\",\"crossreferences\":\"\",\"rank\":\"14805\",\"highlights\":\"<strong>wzm\\u00f3c<\\/strong><em> \\u2011mog\\u0119 \\u2011mo\\u017cesz \\u2011m\\u00f3g\\u0142 \\u2011mog\\u0142a pf, impf <\\/em><strong>wzmaga\\u0107<\\/strong> heighten. <strong>~ si\\u0119<\\/strong> <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, intensify, take on strength\\r\"},{\"id\":\"34050\",\"headword\":\"wzrost\",\"embedded_definition\":\"<strong>wzrost<\\/strong><em> mi 1 <\\/em>height. 2 growth, increase, expansion\\r\",\"crossreferences\":\"\",\"rank\":\"241\",\"highlights\":\"<strong>wzrost<\\/strong><em> mi 1 <\\/em>height. 2 growth, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, expansion\\r\"},{\"id\":\"36902\",\"headword\":\"zwi\\u0119kszy\\u0107\",\"embedded_definition\":\"<strong>zwi\\u0119kszy\\u0107<\\/strong><em> \\u2011sz\\u0119 \\u2011szysz pf, impf <\\/em><strong>zwi\\u0119ksza\\u0107 <\\/strong>increase, augment, boost \\r\",\"crossreferences\":\"\",\"rank\":\"1216\",\"highlights\":\"<strong>zwi\\u0119kszy\\u0107<\\/strong><em> \\u2011sz\\u0119 \\u2011szysz pf, impf <\\/em><strong>zwi\\u0119ksza\\u0107 <\\/strong><span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, augment, boost \\r\"},{\"id\":\"36967\",\"headword\":\"zwy\\u017ckowa\\u0107\",\"embedded_definition\":\"<strong>zwy\\u017ckowa\\u0107<\\/strong><em> \\u2011kuj\\u0119 <\\/em><strong>\\u2011<\\/strong><em>jesz impf <\\/em><strong>be on the rise, increase, tend upward<\\/strong>\\r\",\"crossreferences\":\"\",\"rank\":\"11934\",\"highlights\":\"<strong>zwy\\u017ckowa\\u0107<\\/strong><em> \\u2011kuj\\u0119 <\\/em><strong>\\u2011<\\/strong><em>jesz impf <\\/em><strong>be on the rise, <span style=\\\"background-color: #FFFF88;text-decoration: inherit;\\\">increase<\\/span>, tend upward<\\/strong>\\r\"}]}"

        checkParsedResponse(jsonResponse)
    }

    fun checkParsedResponse(jsonResponse: String) {
        val searchResult = Gson().fromJson(jsonResponse, SearchResponse::class.java)
        assertNotNull(searchResult)
        assertNotEquals(searchResult.totalEntriesFound, 0)
        assertNotEquals(searchResult.totalPagesFound, 0)
        assertNotEquals(searchResult.currentPageSize, 0)
        assertNotEquals(searchResult.currentEntriesFound, 0)
        assertNotEquals(searchResult.nextPage, 0)
        assertNotNull(searchResult.foundAs)
        assertNotNull(searchResult.userSearchString)
        assertNotNull(searchResult.searchModel)
        assertNotNull(searchResult.results)
        assertNotEquals(searchResult.results.count(), 0)

        for (result in searchResult.results) {
            assertNotEquals(result.id, 0)
            assertNotNull(result.headword)
            assertNotNull(result.embeddedDefinition)
            assertNotNull(result.rank)
            assertNotNull(result.highlights)
        }
    }
}