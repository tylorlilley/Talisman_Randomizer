package com.tylorlilley.talismanrandomizer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;

public class CustomizeActivity extends SettingsActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_customize);

        // Initialize SharedPreferences
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = pref.edit();
        updateCheckBoxes();
    }

    protected void selectedRandomizerOption() {
        finish();
    }

    protected void selectedSettingsOption() {
        finish();
        startActivity(new Intent(this, SettingsActivity.class));
    }

    protected void selectedAboutOption() {
        finish();
        startActivity(new Intent(this, AboutActivity.class));
    }

    protected void selectedCustomizeOption() {
        closeOptionsMenu();
    }

    private void updateCheckBoxes() {
        // Base Game Check Boxes
        ((CheckBox)findViewById(R.id.assassinBox)).setChecked(pref.getBoolean(getString(R.string.assassin), true));
        ((CheckBox)findViewById(R.id.druidBox)).setChecked(pref.getBoolean(getString(R.string.druid), true));
        ((CheckBox)findViewById(R.id.dwarfBox)).setChecked(pref.getBoolean(getString(R.string.dwarf), true));
        ((CheckBox)findViewById(R.id.elfBox)).setChecked(pref.getBoolean(getString(R.string.elf), true));
        ((CheckBox)findViewById(R.id.ghoulBox)).setChecked(pref.getBoolean(getString(R.string.ghoul), true));
        ((CheckBox)findViewById(R.id.minstrelBox)).setChecked(pref.getBoolean(getString(R.string.minstrel), true));
        ((CheckBox)findViewById(R.id.monkBox)).setChecked(pref.getBoolean(getString(R.string.monk), true));
        ((CheckBox)findViewById(R.id.priestBox)).setChecked(pref.getBoolean(getString(R.string.priest), true));
        ((CheckBox)findViewById(R.id.prophetessBox)).setChecked(pref.getBoolean(getString(R.string.prophetess), true));
        ((CheckBox)findViewById(R.id.sorceressBox)).setChecked(pref.getBoolean(getString(R.string.sorceress), true));
        ((CheckBox)findViewById(R.id.thiefBox)).setChecked(pref.getBoolean(getString(R.string.thief), true));
        ((CheckBox)findViewById(R.id.trollBox)).setChecked(pref.getBoolean(getString(R.string.troll), true));
        ((CheckBox)findViewById(R.id.warriorBox)).setChecked(pref.getBoolean(getString(R.string.warrior), true));
        ((CheckBox)findViewById(R.id.wizardBox)).setChecked(pref.getBoolean(getString(R.string.wizard), true));
        ((CheckBox)findViewById(R.id.crownOfCommandBox)).setChecked(pref.getBoolean(getString(R.string.crown_of_command), true));

        // Reaper Check Boxes
        ((CheckBox)findViewById(R.id.darkCultistBox)).setChecked(pref.getBoolean(getString(R.string.dark_cultist), true));
        ((CheckBox)findViewById(R.id.knightBox)).setChecked(pref.getBoolean(getString(R.string.knight), true));
        ((CheckBox)findViewById(R.id.merchantBox)).setChecked(pref.getBoolean(getString(R.string.merchant), true));
        ((CheckBox)findViewById(R.id.sageBox)).setChecked(pref.getBoolean(getString(R.string.sage), true));
        ((CheckBox)findViewById(R.id.danseMacabreBox)).setChecked(pref.getBoolean(getString(R.string.danse_macabre), true));

        // Dungeon Check Boxes
        ((CheckBox)findViewById(R.id.amazonBox)).setChecked(pref.getBoolean(getString(R.string.amazon), true));
        ((CheckBox)findViewById(R.id.gladiatorBox)).setChecked(pref.getBoolean(getString(R.string.gladiator), true));
        ((CheckBox)findViewById(R.id.gypsyBox)).setChecked(pref.getBoolean(getString(R.string.gypsy), true));
        ((CheckBox)findViewById(R.id.philosopherBox)).setChecked(pref.getBoolean(getString(R.string.philosopher), true));
        ((CheckBox)findViewById(R.id.swashbucklerBox)).setChecked(pref.getBoolean(getString(R.string.swashbuckler), true));

        // Frostmarch Check Boxes
        ((CheckBox)findViewById(R.id.leprechaunBox)).setChecked(pref.getBoolean(getString(R.string.leprechaun), true));
        ((CheckBox)findViewById(R.id.necromancerBox)).setChecked(pref.getBoolean(getString(R.string.necromancer), true));
        ((CheckBox)findViewById(R.id.ogreChieftainBox)).setChecked(pref.getBoolean(getString(R.string.ogre_chieftain), true));
        ((CheckBox)findViewById(R.id.warlockBox)).setChecked(pref.getBoolean(getString(R.string.warlock), true));
        ((CheckBox)findViewById(R.id.crownAndSceptreBox)).setChecked(pref.getBoolean(getString(R.string.crown_and_sceptre), true));
        ((CheckBox)findViewById(R.id.iceQueenBox)).setChecked(pref.getBoolean(getString(R.string.ice_queen), true));
        ((CheckBox)findViewById(R.id.warlockQuestsBox)).setChecked(pref.getBoolean(getString(R.string.warlock_quests), true));

        // Highlands Check Boxes
        ((CheckBox)findViewById(R.id.alchemistBox)).setChecked(pref.getBoolean(getString(R.string.alchemist), true));
        ((CheckBox)findViewById(R.id.highlanderBox)).setChecked(pref.getBoolean(getString(R.string.highlander), true));
        ((CheckBox)findViewById(R.id.rogueBox)).setChecked(pref.getBoolean(getString(R.string.rogue), true));
        ((CheckBox)findViewById(R.id.spriteBox)).setChecked(pref.getBoolean(getString(R.string.sprite), true));
        ((CheckBox)findViewById(R.id.valkyrieBox)).setChecked(pref.getBoolean(getString(R.string.valkyrie), true));
        ((CheckBox)findViewById(R.id.vampiressBox)).setChecked(pref.getBoolean(getString(R.string.vampiress), true));
        ((CheckBox)findViewById(R.id.battleRoyaleBox)).setChecked(pref.getBoolean(getString(R.string.battle_royale), true));
        ((CheckBox)findViewById(R.id.eagleKingBox)).setChecked(pref.getBoolean(getString(R.string.eagle_king), true));
        ((CheckBox)findViewById(R.id.handOfDoomBox)).setChecked(pref.getBoolean(getString(R.string.hand_of_doom), true));

        // Sacred Pool Check Boxes
        ((CheckBox)findViewById(R.id.chivalricKnightBox)).setChecked(pref.getBoolean(getString(R.string.chivalric_knight), true));
        ((CheckBox)findViewById(R.id.clericBox)).setChecked(pref.getBoolean(getString(R.string.cleric), true));
        ((CheckBox)findViewById(R.id.dreadKnightBox)).setChecked(pref.getBoolean(getString(R.string.dread_knight), true));
        ((CheckBox)findViewById(R.id.magusBox)).setChecked(pref.getBoolean(getString(R.string.magus), true));
        ((CheckBox)findViewById(R.id.demonLordBox)).setChecked(pref.getBoolean(getString(R.string.demon_lord), true));
        ((CheckBox)findViewById(R.id.judgementDayBox)).setChecked(pref.getBoolean(getString(R.string.judgement_day), true));
        ((CheckBox)findViewById(R.id.sacredPoolBox)).setChecked(pref.getBoolean(getString(R.string.sacred_pool), true));

        // Dragon Check Boxes
        ((CheckBox)findViewById(R.id.conjurerBox)).setChecked(pref.getBoolean(getString(R.string.conjurer), true));
        ((CheckBox)findViewById(R.id.dragonHunterBox)).setChecked(pref.getBoolean(getString(R.string.dragon_hunter), true));
        ((CheckBox)findViewById(R.id.dragonPriestessBox)).setChecked(pref.getBoolean(getString(R.string.dragon_priestess), true));
        ((CheckBox)findViewById(R.id.dragonRiderBox)).setChecked(pref.getBoolean(getString(R.string.dragon_rider), true));
        ((CheckBox)findViewById(R.id.fireWizardBox)).setChecked(pref.getBoolean(getString(R.string.fire_wizard), true));
        ((CheckBox)findViewById(R.id.minotaurBox)).setChecked(pref.getBoolean(getString(R.string.minotaur), true));
        ((CheckBox)findViewById(R.id.domainOfDragonsBox)).setChecked(pref.getBoolean(getString(R.string.domain_of_dragons), true));
        ((CheckBox)findViewById(R.id.dragonKingBox)).setChecked(pref.getBoolean(getString(R.string.dragon_king), true));
        ((CheckBox)findViewById(R.id.dragonSlayersBox)).setChecked(pref.getBoolean(getString(R.string.dragon_slayers), true));

        // Blood Moon Check Boxes
        ((CheckBox)findViewById(R.id.doomsayerBox)).setChecked(pref.getBoolean(getString(R.string.doomsayer), true));
        ((CheckBox)findViewById(R.id.graveRobberBox)).setChecked(pref.getBoolean(getString(R.string.grave_robber), true));
        ((CheckBox)findViewById(R.id.vampireHunterBox)).setChecked(pref.getBoolean(getString(R.string.vampire_hunter), true));
        ((CheckBox)findViewById(R.id.bloodMoonWerewolfBox)).setChecked(pref.getBoolean(getString(R.string.blood_moon_werewolf), true));
        ((CheckBox)findViewById(R.id.horribleBlackVoidBox)).setChecked(pref.getBoolean(getString(R.string.horrible_black_void), true));
        ((CheckBox)findViewById(R.id.lightbearersBox)).setChecked(pref.getBoolean(getString(R.string.lightbearers), true));

        // City Check Boxes
        ((CheckBox)findViewById(R.id.bountyHunterBox)).setChecked(pref.getBoolean(getString(R.string.bounty_hunter), true));
        ((CheckBox)findViewById(R.id.catBurglarBox)).setChecked(pref.getBoolean(getString(R.string.cat_burglar), true));
        ((CheckBox)findViewById(R.id.elementalistBox)).setChecked(pref.getBoolean(getString(R.string.elementalist), true));
        ((CheckBox)findViewById(R.id.spyBox)).setChecked(pref.getBoolean(getString(R.string.spy), true));
        ((CheckBox)findViewById(R.id.tavernMaidBox)).setChecked(pref.getBoolean(getString(R.string.tavern_maid), true));
        ((CheckBox)findViewById(R.id.tinkererBox)).setChecked(pref.getBoolean(getString(R.string.tinkerer), true));
        ((CheckBox)findViewById(R.id.assassinsGuildBox)).setChecked(pref.getBoolean(getString(R.string.assassins_guild), true));
        ((CheckBox)findViewById(R.id.merchantsGuildBox)).setChecked(pref.getBoolean(getString(R.string.merchants_guild), true));
        ((CheckBox)findViewById(R.id.thievesGuildBox)).setChecked(pref.getBoolean(getString(R.string.thieves_guild), true));

        // Firelands Check Boxes
        ((CheckBox)findViewById(R.id.dervishBox)).setChecked(pref.getBoolean(getString(R.string.dervish), true));
        ((CheckBox)findViewById(R.id.jinBloodedBox)).setChecked(pref.getBoolean(getString(R.string.jin_blooded), true));
        ((CheckBox)findViewById(R.id.nomadBox)).setChecked(pref.getBoolean(getString(R.string.nomad), true));
        ((CheckBox)findViewById(R.id.warlordBox)).setChecked(pref.getBoolean(getString(R.string.warlord), true));
        ((CheckBox)findViewById(R.id.aHeroRisesBox)).setChecked(pref.getBoolean(getString(R.string.a_hero_rises), true));
        ((CheckBox)findViewById(R.id.crownOfFlameBox)).setChecked(pref.getBoolean(getString(R.string.crown_of_flame), true));
        ((CheckBox)findViewById(R.id.spreadingFlamesBox)).setChecked(pref.getBoolean(getString(R.string.spreading_flames), true));

        // Woodland Check Boxes
        ((CheckBox)findViewById(R.id.ancientOakBox)).setChecked(pref.getBoolean(getString(R.string.ancient_oak), true));
        ((CheckBox)findViewById(R.id.leywalkerBox)).setChecked(pref.getBoolean(getString(R.string.leywalker), true));
        ((CheckBox)findViewById(R.id.scoutBox)).setChecked(pref.getBoolean(getString(R.string.scout), true));
        ((CheckBox)findViewById(R.id.spiderQueenBox)).setChecked(pref.getBoolean(getString(R.string.spider_queen), true));
        ((CheckBox)findViewById(R.id.totemWarriorBox)).setChecked(pref.getBoolean(getString(R.string.totem_warrior), true));
        ((CheckBox)findViewById(R.id.judgedByFateBox)).setChecked(pref.getBoolean(getString(R.string.judged_by_fate), true));
        ((CheckBox)findViewById(R.id.wanderlustBox)).setChecked(pref.getBoolean(getString(R.string.wanderlust), true));
        ((CheckBox)findViewById(R.id.warOfSeasonsBox)).setChecked(pref.getBoolean(getString(R.string.war_of_seasons), true));

        // Harbinger Check Boxes
        ((CheckBox)findViewById(R.id.ascendantDivineBox)).setChecked(pref.getBoolean(getString(R.string.ascendant_divine), true));
        ((CheckBox)findViewById(R.id.celestialBox)).setChecked(pref.getBoolean(getString(R.string.celestial), true));
        ((CheckBox)findViewById(R.id.possessedBox)).setChecked(pref.getBoolean(getString(R.string.possessed), true));
        ((CheckBox)findViewById(R.id.armageddonCrownBox)).setChecked(pref.getBoolean(getString(R.string.armageddon_crown), true));
        ((CheckBox)findViewById(R.id.endOfDaysBox)).setChecked(pref.getBoolean(getString(R.string.end_of_days), true));

        // Cataclysm Check Boxes
        ((CheckBox)findViewById(R.id.arcaneScionBox)).setChecked(pref.getBoolean(getString(R.string.arcane_scion), true));
        ((CheckBox)findViewById(R.id.barbarianBox)).setChecked(pref.getBoolean(getString(R.string.barbarian), true));
        ((CheckBox)findViewById(R.id.blackKnightBox)).setChecked(pref.getBoolean(getString(R.string.black_knight), true));
        ((CheckBox)findViewById(R.id.mutantBox)).setChecked(pref.getBoolean(getString(R.string.mutant), true));
        ((CheckBox)findViewById(R.id.scavengerBox)).setChecked(pref.getBoolean(getString(R.string.scavenger), true));
        ((CheckBox)findViewById(R.id.cultOfTheDamnedBox)).setChecked(pref.getBoolean(getString(R.string.cult_of_the_damned), true));
        ((CheckBox)findViewById(R.id.landsOfWonderBox)).setChecked(pref.getBoolean(getString(R.string.lands_of_wonder), true));
        ((CheckBox)findViewById(R.id.theEternalCrownBox)).setChecked(pref.getBoolean(getString(R.string.the_eternal_crown), true));
        ((CheckBox)findViewById(R.id.theOneTalismanBox)).setChecked(pref.getBoolean(getString(R.string.the_one_talisman), true));

        // Realms Untravelled Check Boxes
        ((CheckBox)findViewById(R.id.pandorasBoxBox)).setChecked(pref.getBoolean(getString(R.string.pandoras_box), true));
        ((CheckBox)findViewById(R.id.theGauntletBox)).setChecked(pref.getBoolean(getString(R.string.the_gauntlet), true));
        ((CheckBox)findViewById(R.id.theHuntBox)).setChecked(pref.getBoolean(getString(R.string.the_hunt), true));
        ((CheckBox)findViewById(R.id.netherPortalBox)).setChecked(pref.getBoolean(getString(R.string.nether_portal), true));
        ((CheckBox)findViewById(R.id.lordOfDarknessBox)).setChecked(pref.getBoolean(getString(R.string.lord_of_darkness), true));
        ((CheckBox)findViewById(R.id.realmwalkersBox)).setChecked(pref.getBoolean(getString(R.string.realmwalkers), true));

        // Digital Edition Check Boxes
        ((CheckBox)findViewById(R.id.pirateBox)).setChecked(pref.getBoolean(getString(R.string.pirate), true));
        ((CheckBox)findViewById(R.id.ninjaBox)).setChecked(pref.getBoolean(getString(R.string.ninja), true));
        ((CheckBox)findViewById(R.id.exorcistBox)).setChecked(pref.getBoolean(getString(R.string.exorcist), true));
        ((CheckBox)findViewById(R.id.courtesanBox)).setChecked(pref.getBoolean(getString(R.string.courtesan), true));
        ((CheckBox)findViewById(R.id.devilsMinionBox)).setChecked(pref.getBoolean(getString(R.string.devils_minion), true));
        ((CheckBox)findViewById(R.id.genieBox)).setChecked(pref.getBoolean(getString(R.string.genie), true));
        ((CheckBox)findViewById(R.id.martyrBox)).setChecked(pref.getBoolean(getString(R.string.martyr), true));
        ((CheckBox)findViewById(R.id.gamblerBox)).setChecked(pref.getBoolean(getString(R.string.gambler), true));
        ((CheckBox)findViewById(R.id.blackWitchBox)).setChecked(pref.getBoolean(getString(R.string.black_witch), true));
        ((CheckBox)findViewById(R.id.apprenticeMageBox)).setChecked(pref.getBoolean(getString(R.string.apprentice_mage), true));
        ((CheckBox)findViewById(R.id.shapeShifterBox)).setChecked(pref.getBoolean(getString(R.string.shape_shifter), true));
        ((CheckBox)findViewById(R.id.shamanBox)).setChecked(pref.getBoolean(getString(R.string.shaman), true));
        ((CheckBox)findViewById(R.id.illusionistBox)).setChecked(pref.getBoolean(getString(R.string.illusionist), true));
        ((CheckBox)findViewById(R.id.jesterBox)).setChecked(pref.getBoolean(getString(R.string.jester), true));
        ((CheckBox)findViewById(R.id.goblinShamanBox)).setChecked(pref.getBoolean(getString(R.string.goblin_shaman), true));
        ((CheckBox)findViewById(R.id.woodsmanBox)).setChecked(pref.getBoolean(getString(R.string.woodsman), true));
        ((CheckBox)findViewById(R.id.pathfinderBox)).setChecked(pref.getBoolean(getString(R.string.pathfinder), true));
        ((CheckBox)findViewById(R.id.samuraiBox)).setChecked(pref.getBoolean(getString(R.string.samurai), true));
        ((CheckBox)findViewById(R.id.martialArtistBox)).setChecked(pref.getBoolean(getString(R.string.martial_artist), true));
        ((CheckBox)findViewById(R.id.witchDoctorBox)).setChecked(pref.getBoolean(getString(R.string.witch_doctor), true));
        ((CheckBox)findViewById(R.id.sacarenBox)).setChecked(pref.getBoolean(getString(R.string.sacaren), true));
    }

    public void updateGenericSettings(View v) {
        CheckBox currentBox = (CheckBox)v;
        editor.putBoolean(currentBox.getText().toString(), (currentBox.isChecked()));
        editor.apply();
    }
}
