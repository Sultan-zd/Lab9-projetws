package com.example.projetws.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetws.R;
import com.example.projetws.beans.Etudiant;

import java.util.List;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder> {

    private List<Etudiant> etudiants;

    public EtudiantAdapter(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @NonNull
    @Override
    public EtudiantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new EtudiantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EtudiantViewHolder holder, int position) {
        Etudiant etudiant = etudiants.get(position);
        
        String nomComplet = (etudiant.getNom() != null ? etudiant.getNom() : "") + " " + 
                            (etudiant.getPrenom() != null ? etudiant.getPrenom() : "");
        holder.name.setText(nomComplet.trim().isEmpty() ? "Sans nom" : nomComplet);
        
        holder.city.setText(etudiant.getVille() != null && !etudiant.getVille().isEmpty() ? etudiant.getVille() : "Ville non spécifiée");
        
        String sexe = etudiant.getSexe();
        if (sexe != null && !sexe.isEmpty()) {
            holder.gender.setText(sexe.substring(0, 1).toUpperCase());
        } else {
            holder.gender.setText("?");
        }
    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }

    public static class EtudiantViewHolder extends RecyclerView.ViewHolder {
        TextView name, city, gender;

        public EtudiantViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            city = itemView.findViewById(R.id.item_city);
            gender = itemView.findViewById(R.id.item_gender);
        }
    }
}