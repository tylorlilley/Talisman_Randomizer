package com.tylorlilley.talismanrandomizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends BasicActivity {

    private int MIN_PLAYERS = 1;
    private int MAX_PLAYERS = 6;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Random rand = new Random();
    private Set<Character> characters; // = new HashSet<Character>();
    private Set<AlternateEnding> endings; // = new HashSet<AlternateEnding>();
    //private Set<Integer> expansions// = new HashSet<Integer>();
    MediaPlayer bell; // = MediaPlayer.create(getApplicationContext(), R.raw.bell);
    MediaPlayer choir; // = MediaPlayer.create(getApplicationContext(), R.raw.bell);

    /// App Lifecycle Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Arrays
        bell = MediaPlayer.create(getApplicationContext(), R.raw.bell);
        choir = MediaPlayer.create(getApplicationContext(), R.raw.choir);
        characters = new HashSet<Character>();
        endings = new HashSet<AlternateEnding>();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize game arrays
        initializeGameArrays();
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadGameArrays();
        updateTextFields();
    }
    @Override
    protected void onPause() {
        super.onPause();
        savePlayerNames();
    }

    // Run Appropriate Activities
    protected void selectedRandomizerOption() {
        closeOptionsMenu();
    }
    protected void selectedSettingsOption() {
        startActivity(new Intent(this, SettingsActivity.class));
    }
    protected void selectedCustomizeOption() {
        startActivity(new Intent(this, CustomizeActivity.class));
    }
    protected void selectedAboutOption() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    // Save, Load, or Replace Game Arrays
    private void initializeGameArrays() {

        // Initialize SharedPreferences
        pref = PreferenceManager.getDefaultSharedPreferences(this );
        editor = pref.edit();
        //pref.edit().clear().commit();


        // Initialize Settings
        if (!pref.getBoolean(getString(R.string.initialized), false)) {
            // Do first time set-up
            editor.putBoolean(getString(R.string.base_game), true);
            editor.putBoolean(getString(R.string.assassin), true);
            editor.putBoolean(getString(R.string.druid), true);
            editor.putBoolean(getString(R.string.dwarf), true);
            editor.putBoolean(getString(R.string.elf), true);
            editor.putBoolean(getString(R.string.ghoul), true);
            editor.putBoolean(getString(R.string.minstrel), true);
            editor.putBoolean(getString(R.string.monk), true);
            editor.putBoolean(getString(R.string.priest), true);
            editor.putBoolean(getString(R.string.prophetess), true);
            editor.putBoolean(getString(R.string.sorceress), true);
            editor.putBoolean(getString(R.string.troll), true);
            editor.putBoolean(getString(R.string.thief), true);
            editor.putBoolean(getString(R.string.wizard), true);
            editor.putBoolean(getString(R.string.warrior), true);
            editor.putBoolean(getString(R.string.crown_of_command), true);

            editor.putBoolean(getString(R.string.reaper_expansion), false);
            editor.putBoolean(getString(R.string.dark_cultist), true);
            editor.putBoolean(getString(R.string.knight), true);
            editor.putBoolean(getString(R.string.merchant), true);
            editor.putBoolean(getString(R.string.sage), true);
            editor.putBoolean(getString(R.string.danse_macabre), true);

            editor.putBoolean(getString(R.string.dungeon_expansion), false);
            editor.putBoolean(getString(R.string.amazon), true);
            editor.putBoolean(getString(R.string.gladiator), true);
            editor.putBoolean(getString(R.string.gypsy), true);
            editor.putBoolean(getString(R.string.philosopher), true);
            editor.putBoolean(getString(R.string.swashbuckler), true);

            editor.putBoolean(getString(R.string.frostmarch_expansion), false);
            editor.putBoolean(getString(R.string.leprechaun), true);
            editor.putBoolean(getString(R.string.necromancer), true);
            editor.putBoolean(getString(R.string.ogre_chieftain), true);
            editor.putBoolean(getString(R.string.warlock), true);
            editor.putBoolean(getString(R.string.crown_and_sceptre), true);
            editor.putBoolean(getString(R.string.ice_queen), true);
            editor.putBoolean(getString(R.string.warlock_quests), true);

            editor.putBoolean(getString(R.string.highland_expansion), false);
            editor.putBoolean(getString(R.string.alchemist), true);
            editor.putBoolean(getString(R.string.highlander), true);
            editor.putBoolean(getString(R.string.rogue), true);
            editor.putBoolean(getString(R.string.sprite), true);
            editor.putBoolean(getString(R.string.valkyrie), true);
            editor.putBoolean(getString(R.string.vampiress), true);
            editor.putBoolean(getString(R.string.battle_royale), true);
            editor.putBoolean(getString(R.string.eagle_king), true);
            editor.putBoolean(getString(R.string.hand_of_doom), true);

            editor.putBoolean(getString(R.string.sacred_pool_expansion), false);
            editor.putBoolean(getString(R.string.chivalric_knight), true);
            editor.putBoolean(getString(R.string.cleric), true);
            editor.putBoolean(getString(R.string.dread_knight), true);
            editor.putBoolean(getString(R.string.magus), true);
            editor.putBoolean(getString(R.string.demon_lord), true);
            editor.putBoolean(getString(R.string.judgement_day), true);
            editor.putBoolean(getString(R.string.sacred_pool), true);

            editor.putBoolean(getString(R.string.dragon_expansion), false);
            editor.putBoolean(getString(R.string.conjurer), true);
            editor.putBoolean(getString(R.string.dragon_hunter), true);
            editor.putBoolean(getString(R.string.dragon_priestess), true);
            editor.putBoolean(getString(R.string.dragon_rider), true);
            editor.putBoolean(getString(R.string.fire_wizard), true);
            editor.putBoolean(getString(R.string.minotaur), true);
            editor.putBoolean(getString(R.string.domain_of_dragons), true);
            editor.putBoolean(getString(R.string.dragon_king), true);
            editor.putBoolean(getString(R.string.dragon_slayers), true);

            editor.putBoolean(getString(R.string.blood_moon_expansion), false);
            editor.putBoolean(getString(R.string.doomsayer), true);
            editor.putBoolean(getString(R.string.grave_robber), true);
            editor.putBoolean(getString(R.string.vampire_hunter), true);
            editor.putBoolean(getString(R.string.blood_moon_werewolf), true);
            editor.putBoolean(getString(R.string.horrible_black_void), true);
            editor.putBoolean(getString(R.string.lightbearers), true);

            editor.putBoolean(getString(R.string.city_expansion), false);
            editor.putBoolean(getString(R.string.bounty_hunter), true);
            editor.putBoolean(getString(R.string.cat_burglar), true);
            editor.putBoolean(getString(R.string.elementalist), true);
            editor.putBoolean(getString(R.string.spy), true);
            editor.putBoolean(getString(R.string.tavern_maid), true);
            editor.putBoolean(getString(R.string.tinkerer), true);
            editor.putBoolean(getString(R.string.thieves_guild), true);
            editor.putBoolean(getString(R.string.merchants_guild), true);
            editor.putBoolean(getString(R.string.assassins_guild), true);

            editor.putBoolean(getString(R.string.firelands_expansion), false);
            editor.putBoolean(getString(R.string.dervish), true);
            editor.putBoolean(getString(R.string.jin_blooded), true);
            editor.putBoolean(getString(R.string.nomad), true);
            editor.putBoolean(getString(R.string.warlord), true);
            editor.putBoolean(getString(R.string.crown_of_flame), true);
            editor.putBoolean(getString(R.string.spreading_flames), true);
            editor.putBoolean(getString(R.string.a_hero_rises), true);

            editor.putBoolean(getString(R.string.woodland_expansion), false);
            editor.putBoolean(getString(R.string.ancient_oak), true);
            editor.putBoolean(getString(R.string.leywalker), true);
            editor.putBoolean(getString(R.string.scout), true);
            editor.putBoolean(getString(R.string.spider_queen), true);
            editor.putBoolean(getString(R.string.totem_warrior), true);
            editor.putBoolean(getString(R.string.judged_by_fate), true);
            editor.putBoolean(getString(R.string.wanderlust), true);
            editor.putBoolean(getString(R.string.war_of_seasons), true);

            editor.putBoolean(getString(R.string.harbinger_expansion), false);
            editor.putBoolean(getString(R.string.ascendant_divine), true);
            editor.putBoolean(getString(R.string.celestial), true);
            editor.putBoolean(getString(R.string.possessed), true);
            editor.putBoolean(getString(R.string.armageddon_crown), true);
            editor.putBoolean(getString(R.string.end_of_days), true);

            editor.putBoolean(getString(R.string.cataclysm_expansion), false);
            editor.putBoolean(getString(R.string.arcane_scion), true);
            editor.putBoolean(getString(R.string.barbarian), true);
            editor.putBoolean(getString(R.string.black_knight), true);
            editor.putBoolean(getString(R.string.mutant), true);
            editor.putBoolean(getString(R.string.scavenger), true);
            editor.putBoolean(getString(R.string.cult_of_the_damned), true);
            editor.putBoolean(getString(R.string.lands_of_wonder), true);
            editor.putBoolean(getString(R.string.the_eternal_crown), true);
            editor.putBoolean(getString(R.string.the_one_talisman), true);

            editor.putBoolean(getString(R.string.nether_realm_expansion), false);
            editor.putBoolean(getString(R.string.pandoras_box), true);
            editor.putBoolean(getString(R.string.the_gauntlet), true);
            editor.putBoolean(getString(R.string.the_hunt), true);

            editor.putBoolean(getString(R.string.realms_untraveled_expansion), false);
            editor.putBoolean(getString(R.string.nether_portal), true);
            editor.putBoolean(getString(R.string.lord_of_darkness), true);
            editor.putBoolean(getString(R.string.realmwalkers), true);

            editor.putBoolean(getString(R.string.digital_edition_expansion), false);
            editor.putBoolean(getString(R.string.pirate), true);
            editor.putBoolean(getString(R.string.ninja), true);
            editor.putBoolean(getString(R.string.exorcist), true);
            editor.putBoolean(getString(R.string.courtesan), true);
            editor.putBoolean(getString(R.string.devils_minion), true);
            editor.putBoolean(getString(R.string.genie), true);
            editor.putBoolean(getString(R.string.martyr), true);
            editor.putBoolean(getString(R.string.gambler), true);
            editor.putBoolean(getString(R.string.black_witch), true);
            editor.putBoolean(getString(R.string.apprentice_mage), true);
            editor.putBoolean(getString(R.string.shape_shifter), true);
            editor.putBoolean(getString(R.string.shaman), true);
            editor.putBoolean(getString(R.string.illusionist), true);
            editor.putBoolean(getString(R.string.jester), true);
            editor.putBoolean(getString(R.string.goblin_shaman), true);
            editor.putBoolean(getString(R.string.woodsman), true);
            editor.putBoolean(getString(R.string.pathfinder), true);
            editor.putBoolean(getString(R.string.samurai), true);
            editor.putBoolean(getString(R.string.martial_artist), true);
            editor.putBoolean(getString(R.string.witch_doctor), true);
            editor.putBoolean(getString(R.string.sacaren), true);

            editor.putBoolean(getString(R.string.revealed_only), false);
            editor.putBoolean(getString(R.string.hidden_only), false);
            editor.putBoolean(getString(R.string.ending_is_hidden), false);
            editor.putString("Current Ending", "No Ending");
            editor.putString("Player 1", "No Character");
            editor.putString("Player 2", "No Character");
            editor.putString("Player 3", "No Character");
            editor.putString("Player 4", "No Character");
            editor.putString("Player 5", "No Character");
            editor.putString("Player 6", "No Character");
            editor.putInt(getString(R.string.number_of_players), 4);
            editor.putBoolean(getString(R.string.initialized), true);
            editor.commit();
            randomizeGameConfiguration();
        }
        else {
            // Load last configuration
            loadGameArrays();
            hideAndRevealFields(false);
        }
    }
    private void getNewGameArrays() {
        // Create shuffled array of characters
        characters = new HashSet<Character>();

        // Add Base Game Characters
        if (pref.getBoolean(getString(R.string.base_game), true)) {
            if (pref.getBoolean(getString(R.string.priest), true)) { characters.add(new Character(getString(R.string.priest), 0)); }
            if (pref.getBoolean(getString(R.string.monk), true)) { characters.add(new Character(getString(R.string.monk), 0)); }
            if (pref.getBoolean(getString(R.string.warrior), true)) { characters.add(new Character(getString(R.string.warrior), 0)); }
            if (pref.getBoolean(getString(R.string.troll), true)) { characters.add(new Character(getString(R.string.troll), 0)); }
            if (pref.getBoolean(getString(R.string.wizard), true)) { characters.add(new Character(getString(R.string.wizard), 0)); }
            if (pref.getBoolean(getString(R.string.sorceress), true)) { characters.add(new Character(getString(R.string.sorceress), 0)); }
            if (pref.getBoolean(getString(R.string.ghoul), true)) { characters.add(new Character(getString(R.string.ghoul), 0)); }
            if (pref.getBoolean(getString(R.string.minstrel), true)) { characters.add(new Character(getString(R.string.minstrel), 0)); }
            if (pref.getBoolean(getString(R.string.thief), true)) { characters.add(new Character(getString(R.string.thief), 0)); }
            if (pref.getBoolean(getString(R.string.assassin), true)) { characters.add(new Character(getString(R.string.assassin), 0)); }
            if (pref.getBoolean(getString(R.string.druid), true)) { characters.add(new Character(getString(R.string.druid), 0)); }
            if (pref.getBoolean(getString(R.string.dwarf), true)) { characters.add(new Character(getString(R.string.dwarf), 0)); }
            if (pref.getBoolean(getString(R.string.elf), true)) { characters.add(new Character(getString(R.string.elf), 0)); }
            if (pref.getBoolean(getString(R.string.prophetess), true)) { characters.add(new Character(getString(R.string.prophetess), 0)); }
        }

        // Add Reaper Characters
        if (pref.getBoolean(getString(R.string.reaper_expansion), true)) {
            if (pref.getBoolean(getString(R.string.dark_cultist), true)) { characters.add(new Character(getString(R.string.dark_cultist), 1)); }
            if (pref.getBoolean(getString(R.string.knight), true)) { characters.add(new Character(getString(R.string.knight), 1)); }
            if (pref.getBoolean(getString(R.string.merchant), true)) { characters.add(new Character(getString(R.string.merchant), 1)); }
            if (pref.getBoolean(getString(R.string.sage), true)) { characters.add(new Character(getString(R.string.sage), 1)); }
        }

        // Add Dungeon Characters
        if (pref.getBoolean(getString(R.string.dungeon_expansion), true)) {
            if (pref.getBoolean(getString(R.string.amazon), true)) { characters.add(new Character(getString(R.string.amazon), 2)); }
            if (pref.getBoolean(getString(R.string.gladiator), true)) { characters.add(new Character(getString(R.string.gladiator), 2)); }
            if (pref.getBoolean(getString(R.string.gypsy), true)) { characters.add(new Character(getString(R.string.gypsy), 2)); }
            if (pref.getBoolean(getString(R.string.philosopher), true)) { characters.add(new Character(getString(R.string.philosopher), 2)); }
            if (pref.getBoolean(getString(R.string.swashbuckler), true)) { characters.add(new Character(getString(R.string.swashbuckler), 2)); }
        }

        // Add Frostmarch Characters
        if (pref.getBoolean(getString(R.string.frostmarch_expansion), true)) {
            if (pref.getBoolean(getString(R.string.leprechaun), true)) { characters.add(new Character(getString(R.string.leprechaun), 3)); }
            if (pref.getBoolean(getString(R.string.ogre_chieftain), true)) { characters.add(new Character(getString(R.string.ogre_chieftain), 3)); }
            if (pref.getBoolean(getString(R.string.necromancer), true)) { characters.add(new Character(getString(R.string.necromancer), 3)); }
            if (pref.getBoolean(getString(R.string.warlock), true)) { characters.add(new Character(getString(R.string.warlock), 3)); }
        }


        // Add Highlands Characters
        if (pref.getBoolean(getString(R.string.highland_expansion), true)) {
            if (pref.getBoolean(getString(R.string.alchemist), true)) { characters.add(new Character(getString(R.string.alchemist), 4)); }
            if (pref.getBoolean(getString(R.string.highlander), true)) { characters.add(new Character(getString(R.string.highlander), 4)); }
            if (pref.getBoolean(getString(R.string.rogue), true)) { characters.add(new Character(getString(R.string.rogue), 4)); }
            if (pref.getBoolean(getString(R.string.sprite), true)) { characters.add(new Character(getString(R.string.sprite), 4)); }
            if (pref.getBoolean(getString(R.string.valkyrie), true)) { characters.add(new Character(getString(R.string.valkyrie), 4)); }
            if (pref.getBoolean(getString(R.string.vampiress), true)) { characters.add(new Character(getString(R.string.vampiress), 4)); }
        }

        // Add Sacred Pool Characters
        if (pref.getBoolean(getString(R.string.sacred_pool_expansion), true)) {
            if (pref.getBoolean(getString(R.string.chivalric_knight), true)) { characters.add(new Character(getString(R.string.chivalric_knight), 5)); }
            if (pref.getBoolean(getString(R.string.dread_knight), true)) { characters.add(new Character(getString(R.string.dread_knight), 5));}
            if (pref.getBoolean(getString(R.string.cleric), true)) { characters.add(new Character(getString(R.string.cleric), 5)); }
            if (pref.getBoolean(getString(R.string.magus), true)) { characters.add(new Character(getString(R.string.magus), 5)); }
        }

        // Add Dragon Characters
        if (pref.getBoolean(getString(R.string.dragon_expansion), true)) {
            if (pref.getBoolean(getString(R.string.dragon_hunter), true)) { characters.add(new Character(getString(R.string.dragon_hunter), 6)); }
            if (pref.getBoolean(getString(R.string.dragon_priestess), true)) { characters.add(new Character(getString(R.string.dragon_priestess), 6)); };
            if (pref.getBoolean(getString(R.string.dragon_rider), true)) { characters.add(new Character(getString(R.string.dragon_rider), 6)); }
            if (pref.getBoolean(getString(R.string.conjurer), true)) {  characters.add(new Character(getString(R.string.conjurer), 6)); }
            if (pref.getBoolean(getString(R.string.fire_wizard), true)) { characters.add(new Character(getString(R.string.fire_wizard), 6)); }
            if (pref.getBoolean(getString(R.string.minotaur), true)) { characters.add(new Character(getString(R.string.minotaur), 6)); }
        }

        // Add Blood Moon Characters
        if (pref.getBoolean(getString(R.string.blood_moon_expansion), true)) {
            if (pref.getBoolean(getString(R.string.grave_robber), true)) { characters.add(new Character(getString(R.string.grave_robber), 7)); }
            if (pref.getBoolean(getString(R.string.vampire_hunter), true)) {  characters.add(new Character(getString(R.string.vampire_hunter), 7)); }
            if (pref.getBoolean(getString(R.string.doomsayer), true)) { characters.add(new Character(getString(R.string.doomsayer), 7)); }
        }

        // Add City Characters
        if (pref.getBoolean(getString(R.string.city_expansion), true)) {
            if (pref.getBoolean(getString(R.string.tinkerer), true)) { characters.add(new Character(getString(R.string.tinkerer), 8)); }
            if (pref.getBoolean(getString(R.string.tavern_maid), true)) { characters.add(new Character(getString(R.string.tavern_maid), 8)); };
            if (pref.getBoolean(getString(R.string.spy), true)) { characters.add(new Character(getString(R.string.spy), 8)); }
            if (pref.getBoolean(getString(R.string.elementalist), true)) { characters.add(new Character(getString(R.string.elementalist), 8)); }
            if (pref.getBoolean(getString(R.string.bounty_hunter), true)) {  characters.add(new Character(getString(R.string.bounty_hunter), 8)); }
            if (pref.getBoolean(getString(R.string.cat_burglar), true)) { characters.add(new Character(getString(R.string.cat_burglar), 8)); }
        }

        // Add Firelands Characters
        if (pref.getBoolean(getString(R.string.firelands_expansion), true)) {
            if (pref.getBoolean(getString(R.string.dervish), true)) { characters.add(new Character(getString(R.string.dervish), 9)); }
            if (pref.getBoolean(getString(R.string.jin_blooded), true)) { characters.add(new Character(getString(R.string.jin_blooded), 9)); }
            if (pref.getBoolean(getString(R.string.nomad), true)) { characters.add(new Character(getString(R.string.nomad), 9)); }
            if (pref.getBoolean(getString(R.string.warlord), true)) { characters.add(new Character(getString(R.string.warlord), 9)); }
        }

        // Add Woodland Characters
        if (pref.getBoolean(getString(R.string.woodland_expansion), true)) {
            if (pref.getBoolean(getString(R.string.ancient_oak), true)) { characters.add(new Character(getString(R.string.ancient_oak), 10)); }
            if (pref.getBoolean(getString(R.string.leywalker), true)) { characters.add(new Character(getString(R.string.leywalker), 10)); }
            if (pref.getBoolean(getString(R.string.scout), true)) { characters.add(new Character(getString(R.string.scout), 10)); }
            if (pref.getBoolean(getString(R.string.totem_warrior), true)) { characters.add(new Character(getString(R.string.totem_warrior), 10)); }
            if (pref.getBoolean(getString(R.string.spider_queen), true)) { characters.add(new Character(getString(R.string.spider_queen), 10)); }
        }

        // Add Harbinger Characters
        if (pref.getBoolean(getString(R.string.harbinger_expansion), true)) {
            if (pref.getBoolean(getString(R.string.ascendant_divine), true)) { characters.add(new Character(getString(R.string.ascendant_divine), 11)); }
            if (pref.getBoolean(getString(R.string.celestial), true)) { characters.add(new Character(getString(R.string.celestial), 11)); }
            if (pref.getBoolean(getString(R.string.possessed), true)) { characters.add(new Character(getString(R.string.possessed), 11)); }
        }

        // Add Cataclysm Characters
        if (pref.getBoolean(getString(R.string.cataclysm_expansion), true)) {
            if (pref.getBoolean(getString(R.string.barbarian), true)) { characters.add(new Character(getString(R.string.barbarian), 12)); }
            if (pref.getBoolean(getString(R.string.black_knight), true)) { characters.add(new Character(getString(R.string.black_knight), 12)); }
            if (pref.getBoolean(getString(R.string.mutant), true)) { characters.add(new Character(getString(R.string.mutant), 12)); }
            if (pref.getBoolean(getString(R.string.scavenger), true)) { characters.add(new Character(getString(R.string.scavenger), 12)); }
            if (pref.getBoolean(getString(R.string.arcane_scion), true)) { characters.add(new Character(getString(R.string.arcane_scion), 12)); }
        }

        // Add Nether Realms Characters
        //  - None

        // Add Realms Untraveled Characters
        //  - None

        // Add Digital Characters
        if (pref.getBoolean(getString(R.string.digital_edition_expansion), true)) {
            if (pref.getBoolean(getString(R.string.pirate), true)) { characters.add(new Character(getString(R.string.pirate), 15)); }
            if (pref.getBoolean(getString(R.string.ninja), true)) { characters.add(new Character(getString(R.string.ninja), 15)); }
            if (pref.getBoolean(getString(R.string.exorcist), true)) {  characters.add(new Character(getString(R.string.exorcist), 15)); }
            if (pref.getBoolean(getString(R.string.courtesan), true)) {  characters.add(new Character(getString(R.string.courtesan), 15)); }
            if (pref.getBoolean(getString(R.string.devils_minion), true)) { characters.add(new Character(getString(R.string.devils_minion), 15)); }
            if (pref.getBoolean(getString(R.string.genie), true)) { characters.add(new Character(getString(R.string.genie), 15)); }
            if (pref.getBoolean(getString(R.string.martyr), true)) { characters.add(new Character(getString(R.string.martyr), 15)); }
            if (pref.getBoolean(getString(R.string.gambler), true)) { characters.add(new Character(getString(R.string.gambler), 15)); }
            if (pref.getBoolean(getString(R.string.black_witch), true)) { characters.add(new Character(getString(R.string.black_witch), 15)); }
            if (pref.getBoolean(getString(R.string.apprentice_mage), true)) {  characters.add(new Character(getString(R.string.apprentice_mage), 15)); }
            if (pref.getBoolean(getString(R.string.shape_shifter), true)) {  characters.add(new Character(getString(R.string.shape_shifter), 15)); }
            if (pref.getBoolean(getString(R.string.shaman), true)) { characters.add(new Character(getString(R.string.shaman), 15)); }
            if (pref.getBoolean(getString(R.string.illusionist), true)) { characters.add(new Character(getString(R.string.illusionist), 15)); }
            if (pref.getBoolean(getString(R.string.jester), true)) { characters.add(new Character(getString(R.string.jester), 15)); }
            if (pref.getBoolean(getString(R.string.goblin_shaman), true)) { characters.add(new Character(getString(R.string.goblin_shaman), 15)); }
            if (pref.getBoolean(getString(R.string.woodsman), true)) {  characters.add(new Character(getString(R.string.woodsman), 15)); }
            if (pref.getBoolean(getString(R.string.pathfinder), true)) { characters.add(new Character(getString(R.string.pathfinder), 15)); }
            if (pref.getBoolean(getString(R.string.witch_doctor), true)) { characters.add(new Character(getString(R.string.witch_doctor), 15)); }
            if (pref.getBoolean(getString(R.string.sacaren), true)) { characters.add(new Character(getString(R.string.sacaren), 15)); }
            if (pref.getBoolean(getString(R.string.martial_artist), true)) {  characters.add(new Character(getString(R.string.martial_artist), 15)); }
            if (pref.getBoolean(getString(R.string.samurai), true)) { characters.add(new Character(getString(R.string.samurai), 15)); }
        }

        // Create shuffled array of endings
        endings = new HashSet<AlternateEnding>();

        // Add Base Game Endings
        if (pref.getBoolean(getString(R.string.base_game), true)) {
            if (pref.getBoolean(getString(R.string.crown_of_command), true)) { endings.add(new AlternateEnding(getString(R.string.crown_of_command), false, false, 0)); }
        }

        // Add Reaper Endings
        if (pref.getBoolean(getString(R.string.reaper_expansion), true)) {
            if (pref.getBoolean(getString(R.string.danse_macabre), true)) { endings.add(new AlternateEnding(getString(R.string.danse_macabre), false, false, 1)); }
        }

        // Add Dungeon Game Endings
        //  - None

        // Add Frostmarch Endings
        if (pref.getBoolean(getString(R.string.frostmarch_expansion), true)) {
            if (pref.getBoolean(getString(R.string.crown_and_sceptre), true)) { endings.add(new AlternateEnding(getString(R.string.crown_and_sceptre), false, false, 3)); }
            if (pref.getBoolean(getString(R.string.ice_queen), true)) {  endings.add(new AlternateEnding(getString(R.string.ice_queen), false, false, 3)); }
            if (pref.getBoolean(getString(R.string.warlock_quests), true)) { endings.add(new AlternateEnding(getString(R.string.warlock_quests), true, false, 3)); }
        }

        // Add Highland Endings
        if (pref.getBoolean(getString(R.string.highland_expansion), true)) {
            if (pref.getBoolean(getString(R.string.battle_royale), true)) { endings.add(new AlternateEnding(getString(R.string.battle_royale), false, false, 4)); }
            if (pref.getBoolean(getString(R.string.eagle_king), true)) { endings.add(new AlternateEnding(getString(R.string.eagle_king), false, false, 4)); }
            if (pref.getBoolean(getString(R.string.hand_of_doom), true)) {  endings.add(new AlternateEnding(getString(R.string.hand_of_doom), false, false, 4)); }
        }

        // Add Sacred Pool Endings
        if (pref.getBoolean(getString(R.string.sacred_pool_expansion), true)) {
            if (pref.getBoolean(getString(R.string.demon_lord), true)) { endings.add(new AlternateEnding(getString(R.string.demon_lord), false, false, 5)); }
            if (pref.getBoolean(getString(R.string.judgement_day), true)) { endings.add(new AlternateEnding(getString(R.string.judgement_day), false, false, 5)); }
            if (pref.getBoolean(getString(R.string.sacred_pool), true)) { endings.add(new AlternateEnding(getString(R.string.sacred_pool), true, false, 5)); }
        }

        // Add Dragon Endings
        if (pref.getBoolean(getString(R.string.dragon_expansion), true)) {
            if (pref.getBoolean(getString(R.string.dragon_king), true)) { endings.add(new AlternateEnding(getString(R.string.dragon_king), false, false, 6)); }
            if (pref.getBoolean(getString(R.string.domain_of_dragons), true)) { endings.add(new AlternateEnding(getString(R.string.domain_of_dragons), true, false, 6)); }
            if (pref.getBoolean(getString(R.string.dragon_slayers), true)) { endings.add(new AlternateEnding(getString(R.string.dragon_slayers), true, false, 6)); }
        }

        // Add Blood Moon Endings
        if (pref.getBoolean(getString(R.string.blood_moon_expansion), true)) {
            if (pref.getBoolean(getString(R.string.horrible_black_void), true)) {  endings.add(new AlternateEnding(getString(R.string.horrible_black_void), false, true, 7)); }
            if (pref.getBoolean(getString(R.string.blood_moon_werewolf), true)) {  endings.add(new AlternateEnding(getString(R.string.blood_moon_werewolf), false, true, 7)); }
            if (pref.getBoolean(getString(R.string.lightbearers), true)) { endings.add(new AlternateEnding(getString(R.string.lightbearers), true, false, 7)); }
        }

        // Add City Endings
        if (pref.getBoolean(getString(R.string.city_expansion), true)) {
            if (pref.getBoolean(getString(R.string.thieves_guild), true)) { endings.add(new AlternateEnding(getString(R.string.thieves_guild), false, false, 8)); }
            if (pref.getBoolean(getString(R.string.merchants_guild), true)) { endings.add(new AlternateEnding(getString(R.string.merchants_guild), true, false, 8)); }
            if (pref.getBoolean(getString(R.string.assassins_guild), true)) {  endings.add(new AlternateEnding(getString(R.string.assassins_guild), true, false, 8)); }
        }

        // Add Fireland Endings
        if (pref.getBoolean(getString(R.string.firelands_expansion), true)) {
            if (pref.getBoolean(getString(R.string.spreading_flames), true)) {  endings.add(new AlternateEnding(getString(R.string.spreading_flames), false, true, 9)); }
            if (pref.getBoolean(getString(R.string.crown_of_flame), true)) { endings.add(new AlternateEnding(getString(R.string.crown_of_flame), false, true, 9)); }
            if (pref.getBoolean(getString(R.string.a_hero_rises), true)) { endings.add(new AlternateEnding(getString(R.string.a_hero_rises), true, false, 9)); }
        }

        // Add Woodland Endings
        if (pref.getBoolean(getString(R.string.woodland_expansion), true)) {
            if (pref.getBoolean(getString(R.string.war_of_seasons), true)) { endings.add(new AlternateEnding(getString(R.string.war_of_seasons), false, false, 10)); }
            if (pref.getBoolean(getString(R.string.judged_by_fate), true)) { endings.add(new AlternateEnding(getString(R.string.judged_by_fate), false, true, 10)); }
            if (pref.getBoolean(getString(R.string.wanderlust), true)) { endings.add(new AlternateEnding(getString(R.string.wanderlust), true, false, 10)); }
        }

        // Add Harbinger Endings
        if (pref.getBoolean(getString(R.string.harbinger_expansion), true)) {
            if (pref.getBoolean(getString(R.string.armageddon_crown), true)) { endings.add(new AlternateEnding(getString(R.string.armageddon_crown), false, false, 11)); }
            if (pref.getBoolean(getString(R.string.end_of_days), true)) { endings.add(new AlternateEnding(getString(R.string.end_of_days), true, false, 11)); }
        }

        // Add Cataclysm Endings
        if (pref.getBoolean(getString(R.string.cataclysm_expansion), true)) {
            if (pref.getBoolean(getString(R.string.the_eternal_crown), true)) { endings.add(new AlternateEnding(getString(R.string.the_eternal_crown), false, false, 12)); }
            if (pref.getBoolean(getString(R.string.cult_of_the_damned), true)) { endings.add(new AlternateEnding(getString(R.string.cult_of_the_damned), false, true, 12)); }
            if (pref.getBoolean(getString(R.string.the_one_talisman), true)) { endings.add(new AlternateEnding(getString(R.string.the_one_talisman), true, false, 12)); }
            if (pref.getBoolean(getString(R.string.lands_of_wonder), true)) { endings.add(new AlternateEnding(getString(R.string.lands_of_wonder), true, false, 12)); }
        }

        // Add Nether Realm Endings
        if (pref.getBoolean(getString(R.string.nether_realm_expansion), true)) {
            if (pref.getBoolean(getString(R.string.pandoras_box), true)) { endings.add(new AlternateEnding(getString(R.string.pandoras_box), false, false, 13)); }
            if (pref.getBoolean(getString(R.string.the_hunt), true)) { endings.add(new AlternateEnding(getString(R.string.the_hunt), true, false, 13)); }
            if (pref.getBoolean(getString(R.string.the_gauntlet), true)) { endings.add(new AlternateEnding(getString(R.string.the_gauntlet), true, false, 13)); }
        }

        // Add Realms Untraveled Endings
        if (pref.getBoolean(getString(R.string.realms_untraveled_expansion), true)) {
            if (pref.getBoolean(getString(R.string.realmwalkers), true)) { endings.add(new AlternateEnding(getString(R.string.realmwalkers), true, false, 14)); }
            if (pref.getBoolean(getString(R.string.nether_portal), true)) { endings.add(new AlternateEnding(getString(R.string.nether_portal), false, false, 14)); }
            if (pref.getBoolean(getString(R.string.lord_of_darkness), true)) { endings.add(new AlternateEnding(getString(R.string.lord_of_darkness), false, true, 14)); }
        }

        // Add Digital Edition Endings
        //  - None

        // Correct Ending Status of Alternate Endings
        Set<AlternateEnding> newEndings = new HashSet<AlternateEnding>();
        for (AlternateEnding ending : endings) {
            Boolean includeEnding = true;
            if (pref.getBoolean(getString(R.string.hidden_only), false) && !ending.includeInHidden()) { includeEnding = false; }
            if (pref.getBoolean(getString(R.string.revealed_only), false) && !ending.includeInRevealed()) { includeEnding = false; }
            if (includeEnding) { newEndings.add(ending); }
        }
        endings = newEndings;

        saveGameArrays();
    }
    private void saveGameArrays() {
        Set<String> charactersStringSet = new HashSet<String>();
        Set<String> endingsStringSet = new HashSet<String>();

        for (Character character : characters) {
            charactersStringSet.add(character.toString());
        }

        for (AlternateEnding ending : endings) {
            endingsStringSet.add(ending.toString());
        }

        editor.putStringSet("characters", charactersStringSet);
        editor.putStringSet("endings", endingsStringSet);
        editor.commit();
    }
    private void loadGameArrays() {
        characters = new HashSet<Character>();
        endings = new HashSet<AlternateEnding>();

        for (String characterString : pref.getStringSet("characters", new HashSet<String>())) {
            characters.add(new Character(characterString));
        }

        for (String endingString : pref.getStringSet("endings", new HashSet<String>())) {
            endings.add(new AlternateEnding(endingString));
        }
    }


    // Methods used by UI buttons
    public void randomizeButton(View v) {
        randomizeGameConfiguration();
    }
    public void killPlayer1(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(1, true);
    }
    public void killPlayer2(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(2, true);
    }
    public void killPlayer3(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(3, true);
    }
    public void killPlayer4(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(4, true);
    }
    public void killPlayer5(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(5, true);
    }
    public void killPlayer6(View v) throws IOException {
        bell.stop();
        bell.prepare();
        bell.start();
        getNextPlayer(6, true);
    }
    public void revealEnding(View v) throws IOException {
        if (pref.getBoolean(getString(R.string.ending_is_hidden), false)) {
            choir.stop();
            choir.prepare();
            choir.start();
            editor.putBoolean(getString(R.string.ending_is_hidden), false);
            editor.apply();
        } else {
            getNextEnding(true);
        }
        hideAndRevealFields(false);
    }

    private void randomizeGameConfiguration() {
        // Shuffle game arrays
        getNewGameArrays();

        // Select the new ending
        AlternateEnding newEnding = getNextEnding(false);
        if (pref.getBoolean(getString(R.string.hidden_only), true)) {
            editor.putBoolean(getString(R.string.ending_is_hidden), true);
        } else if (pref.getBoolean(getString(R.string.revealed_only), true)) {
            editor.putBoolean(getString(R.string.ending_is_hidden), false);
        } else if (!newEnding.includeInHidden()) {
            editor.putBoolean(getString(R.string.ending_is_hidden), false);
        } else {
            editor.putBoolean(getString(R.string.ending_is_hidden), true);
        }
        editor.apply();

        // Select and reveal new characters
        hideAndRevealFields(true);
    }
    private void getNextPlayer(int playerNumber, boolean isKilled) {
        // Shuffle set of characters remaining and remove one
        Character nextCharacter = null;
        if (characters.size() > 0) {
            ArrayList<Character> characterList = new ArrayList<>();
            for (Character character : characters) {
                characterList.add(character);
            }
            Collections.shuffle(characterList);
            nextCharacter = characterList.get(0);
            characters.remove(nextCharacter);
            saveGameArrays();
        }

        // Save the new character as the chosen character
        String playerString = "Player "+Integer.toString(playerNumber);
        if (nextCharacter == null) {
            editor.putString(playerString, getString(R.string.no_character));
        } else {
            editor.putString(playerString, nextCharacter.getName());
        }
        updateTextFields();
    }
    private AlternateEnding getNextEnding(boolean isNext) {
        // Shuffle set of endings remaining and remove one
        AlternateEnding nextEnding = null;
        if (endings.size() > 0) {
            ArrayList<AlternateEnding> endingList = new ArrayList<>();
            for (AlternateEnding ending : endings) {
                endingList.add(ending);
            }
            Collections.shuffle(endingList);
            nextEnding = endingList.get(0);
            endings.remove(nextEnding);
            saveGameArrays();
        }

        // Save the new ending as the chosen ending
        if (nextEnding == null) {
            editor.putString(getString(R.string.current_ending_label), getString(R.string.no_ending));
        } else {
            editor.putString(getString(R.string.current_ending_label), nextEnding.getName());
        }
        updateTextFields();
        return nextEnding;
    }
    private void updateTextFields() {
        editor.apply();
        ((TextView) findViewById(R.id.player1)).setText(pref.getString("Player 1 Name", "Player 1"));
        ((TextView) findViewById(R.id.player2)).setText(pref.getString("Player 2 Name", "Player 2"));
        ((TextView) findViewById(R.id.player3)).setText(pref.getString("Player 3 Name", "Player 3"));
        ((TextView) findViewById(R.id.player4)).setText(pref.getString("Player 4 Name", "Player 4"));
        ((TextView) findViewById(R.id.player5)).setText(pref.getString("Player 5 Name", "Player 5"));
        ((TextView) findViewById(R.id.player6)).setText(pref.getString("Player 6 Name", "Player 6"));
        ((TextView) findViewById(R.id.character1)).setText(pref.getString("Player 1", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.character2)).setText(pref.getString("Player 2", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.character3)).setText(pref.getString("Player 3", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.character4)).setText(pref.getString("Player 4", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.character5)).setText(pref.getString("Player 5", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.character6)).setText(pref.getString("Player 6", getString(R.string.no_character)));
        ((TextView) findViewById(R.id.revealedEnding)).setText(pref.getString(getString(R.string.current_ending_label), getString(R.string.no_ending)));
    }
    private void hideAndRevealFields(boolean getNewCharacters) {
        ArrayList<View> playerRows = new ArrayList<>();
        playerRows.add(findViewById(R.id.player1Row));
        playerRows.add(findViewById(R.id.player2Row));
        playerRows.add(findViewById(R.id.player3Row));
        playerRows.add(findViewById(R.id.player4Row));
        playerRows.add(findViewById(R.id.player5Row));
        playerRows.add(findViewById(R.id.player6Row));

        for (int i = 1; i <= 6; i++) {
            if (i <= pref.getInt(getString(R.string.number_of_players), 4)) {
                if (getNewCharacters) { getNextPlayer(i, false); }
                playerRows.get(i-1).setVisibility(View.VISIBLE);
            } else {
                String playerString = "Player "+Integer.toString(i);
                editor.putString(playerString, getString(R.string.no_character));
                playerRows.get(i-1).setVisibility(View.GONE);
            }
        }

        // Hide or reveal the ending
        if (pref.getBoolean(getString(R.string.ending_is_hidden), false)) {
            findViewById(R.id.hiddenEnding).setVisibility(View.VISIBLE);
            findViewById(R.id.revealedEnding).setVisibility(View.GONE);
            ((Button) findViewById(R.id.revealButton)).setText(getString(R.string.reveal_button));
        } else {
            findViewById(R.id.hiddenEnding).setVisibility(View.GONE);
            findViewById(R.id.revealedEnding).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.revealButton)).setText(R.string.next_ending_button);
        }
    }
    private void savePlayerNames() {
        editor.putString("Player 1 Name", ((TextView)findViewById(R.id.player1)).getText().toString());
        editor.putString("Player 2 Name", ((TextView)findViewById(R.id.player2)).getText().toString());
        editor.putString("Player 3 Name", ((TextView)findViewById(R.id.player3)).getText().toString());
        editor.putString("Player 4 Name", ((TextView)findViewById(R.id.player4)).getText().toString());
        editor.putString("Player 5 Name", ((TextView)findViewById(R.id.player5)).getText().toString());
        editor.putString("Player 6 Name", ((TextView)findViewById(R.id.player6)).getText().toString());
        editor.commit();
    }
}
